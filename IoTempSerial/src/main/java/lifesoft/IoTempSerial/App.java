package lifesoft.IoTempSerial;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class App 
{
	//private static boolean flag = true;
	private static DB database =  new DB();
	//private static char temp;
	//private static InputStream in;
	
    public static void main( String[] args )
    {
    	database.conectar();
    	SerialPort comPort = SerialPort.getCommPorts()[0];
		comPort.openPort();
		//comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		Scanner scanner = new Scanner(comPort.getInputStream());
		while(scanner.hasNextLine()) {
			try {
				String line = scanner.nextLine();
				int number = Integer.parseInt(line);
				System.out.println(number);
				database.insert("insert into temperatura(temperatura) values("+number+");");
			} catch(Exception e) {}
		}
		scanner.close();
		/*
		try
		{
		   while(flag){
			  in = comPort.getInputStream();
			  temp = (char)(in.read());
		      System.out.print(temp);
		      try{
		    	  database.insert("insert into temperatura(temperatura) values("+temp+");");
		      }catch(Exception e){
		    	  System.out.println("Ouch");
		      }
		      
		   }
		   in.close();
		} catch (Exception e) { e.printStackTrace(); }
		comPort.closePort();
		database.desconectar();*/

		/*comPort.openPort();
		try {
		   while (true)
		   {
		      while (comPort.bytesAvailable() == 0)
		         Thread.sleep(20);

		      byte[] readBuffer = new byte[comPort.bytesAvailable()];
		      int numRead = comPort.readBytes(readBuffer, readBuffer.length);
		      String aux="";
		      for(int i = 0; i<readBuffer.length;i++){
		    	  System.out.println(readBuffer[i]);
		    	  if(readBuffer[i] != 10 && readBuffer[i] != 48)
		    	  aux+=readBuffer[i];
		      }
		      InputStream is = new ByteArrayInputStream(aux.getBytes());
		      System.out.println("Read " + is.read() + " bytes.");
		      //database.insert("insert into temperatura(temperatura) values("+numRead+");");
		   }
		} catch (Exception e) { e.printStackTrace(); }
		comPort.closePort();*/
    }
}
