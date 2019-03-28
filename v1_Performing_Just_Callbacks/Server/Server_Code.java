import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.io.*;

public class Server_Code {

	public static void main(String[] args) {
		
		String portNumber = "1099", registryURL;
		int RMI_PortNumber = 1099;

		try
		{
			startRegistry(RMI_PortNumber);


			Server_Interface_Implementation obj_Server_Interface_Impl = new Server_Interface_Implementation();


			registryURL = "rmi://localhost:" + portNumber + "/callback";
			Naming.rebind(registryURL, obj_Server_Interface_Impl);

			System.out.println("Callback server is ready");
		} //End of try();
		catch(Exception ae)
		{
			System.out.println("Exception in server code: " + ae);
		}
		

	} //End of main() method;


	private static void startRegistry(int RMI_PortNumber)
		 throws java.rmi.RemoteException
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry(RMI_PortNumber);
			registry.list();
		}
		catch(Exception ae)
		{
			Registry registry = LocateRegistry.createRegistry(RMI_PortNumber);
		}

	} //end of startRegistry(int RMI_PortNumber);


} //End of public class Server_Code;