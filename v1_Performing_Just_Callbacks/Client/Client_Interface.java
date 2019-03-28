import java.rmi.*;


public interface Client_Interface extends java.rmi.Remote
{


	public String notifyMe(String message)
		throws java.rmi.RemoteException; 



} //End of public interface  Client_Interface