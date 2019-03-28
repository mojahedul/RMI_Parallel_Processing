import java.io.*;
import java.rmi.*;


public class Client_Code {

	public static void main(String[] args) {
		
		try
		{

			int rmi_Port = 1099;

			String registryURL = "rmi://localhost:" + rmi_Port + "/callback";

			Server_Interface obj_Server_Interface = (Server_Interface)Naming.lookup(registryURL);
			System.out.println("Lookup completed");

			System.out.println("Server said: " + obj_Server_Interface.sayHello() );

			Client_Interface obj_Client_Interface = new Client_Interface_Impl();
			

			obj_Server_Interface.register_To_Server(obj_Client_Interface);
			System.out.println("Registered to server..");

			try
			{
				Thread.sleep(5* 1000);
			}
			catch(InterruptedException ie)
			{
				obj_Server_Interface.unregister_To_Server(obj_Client_Interface);
				System.out.println("Un-Registered from server..");
			}


		} //End of try();
		catch(Exception ae)
		{
			System.out.println("Exception in Client_Code: " + ae);
		}

	} //End of Main() Method;


} //End of public class Client_Code;