

import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
import java.nio.file.*;

public class Server_Interface_Implementation extends UnicastRemoteObject implements Server_Interface
{

	private Vector client_List;
	String input_AsString = "";

	//
	public Server_Interface_Implementation()  throws RemoteException
	{

		super();
		client_List = new Vector();
		

	} //End of public Server_Interface_Implementation();

	String file_Path = "C:\\Users\\Mojahedul\\Desktop\\input.txt";

	




	





	//
	public String sayHello()  throws java.rmi.RemoteException
	{
		return("Server -> Hello..");

	} //End of public String sayHello();





	//
	public void register_To_Server(Client_Interface obj_ClientInterface)
		throws java.rmi.RemoteException
	{

		//
		if( (!client_List.contains(obj_ClientInterface)) )
		{
			client_List.addElement(obj_ClientInterface);
			System.out.println("Registered new client.");


			do_Callbacks();


		} //End of if( (!client_List.contains(obj_ClientInterface)) );

	} //End of register_To_Server(Client_Interface obj_ClientInterface);





	//
	public synchronized void unregister_To_Server(Client_Interface obj_ClientInterface)
		throws java.rmi.RemoteException
	{

		if( ( client_List.contains(obj_ClientInterface)) )
		{
			if( (!client_List.removeElement(obj_ClientInterface)) )
			{
				System.out.println("Client unregistered");
			
			} //End of inner if( (!client_List.removeElement(obj_ClientInterface)) );
		} //End of outer if( ( client_List.contains(obj_ClientInterface)) );

		else
		{
			System.out.println("Client wasn't unregistered");
		}

	} //End of unregister_To_Server(Client_Interface obj_ClientInterface);





	//
	private synchronized void do_Callbacks()
	    throws java.rmi.RemoteException
    {

    	System.out.println("Callbacks initiated..");
    	System.out.println("----------------------");

		for(int i = 0; i < client_List.size(); i++)
		{
			System.out.println("Remote method no: " + i);

			Client_Interface next_Client = (Client_Interface)client_List.elementAt(i);

			System.out.println("Total = " + client_List.size() );
			next_Client.notifyMe("Number of registered clients = " + client_List.size() );
		}

    } //End of private synchronized void do_Callbacks();







} //End of public class Server_Interface_Implementation extends UnicastRemoteObject implements Server_Interface;