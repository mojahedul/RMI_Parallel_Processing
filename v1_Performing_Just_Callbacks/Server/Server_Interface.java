
import java.rmi.*;


public interface Server_Interface extends Remote
{
	//
	public String sayHello()
		throws java.rmi.RemoteException;

	//
	public void register_To_Server(Client_Interface obj_Client_Interface)
		throws java.rmi.RemoteException;

	//	
	public void unregister_To_Server(Client_Interface obj_Client_Interface)
		throws java.rmi.RemoteException;	

	

} //End of public interface Server_Interface extends Remote;