package lifesoft.IoTempSerial;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DB {
	private final String url = "jdbc:mysql://localhost:3306/";
	private final String db = "IoTemperature";
	private final String user = "root";
	private final String pass = "n0m3l0";
	
	private Connection connection = null;
	private Statement statement = null;
//Conectar
	public Connection conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url+db, user, pass);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return connection;
	}
//Insert    
    public void insert(String query) throws SQLException{
       this.statement=(Statement) this.connection.createStatement();
       statement.executeUpdate(query);
    }
//Update
    public void update(String query) throws SQLException{
    	this.statement=(Statement) this.connection.createStatement();
    	statement.executeUpdate(query);
    }
//Select
    public ResultSet select(String query) throws SQLException{
        this.statement = (Statement) this.connection.createStatement();
        return statement.executeQuery(query);
    }
//Borrar
    public int Borrar(String query) throws SQLException {
        this.statement = (Statement) this.connection.createStatement();
        return statement.executeUpdate(query);
    } 
//Desconectar	
	public void desconectar(){
		try{
			this.connection.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
