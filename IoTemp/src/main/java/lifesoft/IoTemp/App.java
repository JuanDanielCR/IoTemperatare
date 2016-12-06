package lifesoft.IoTemp;

import static spark.Spark.get;
import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class App 
{
	private static DB database =  new DB();
	private static String temp = "";
	public static void main( String[] args )
    {
    	//Route for saving our js,css and images
    	setPort(80);
    	staticFileLocation("/public");
    	//Sección Sistema de Calidad
        get(new FreeMarkerRoute("/inicio") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                return modelAndView(attributes, "layout.ftl");
            }
        });
        
        get(new FreeMarkerRoute("/temp/:limit") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                String limit = request.params("limit");
                database.conectar();
                String s = "";
                try{
                	ResultSet rs = database.select("select temperatura from temperatura order by fecha_temperatura desc limit "+limit+";");
                	while(rs.next()){
                		s += rs.getString("temperatura")+",";
                	}
                }catch(Exception e){
                	System.out.println(e.toString());
                }finally{
                	database.desconectar();
                	response.type("text/html");
                }
                System.out.println(s);
                attributes.put("content", s);
                return modelAndView(attributes, "temperature.ftl");
            }
        });

    }
}
