import java.rmi.*;
import java.rmi.server.*;


public class Client_Interface_Impl extends UnicastRemoteObject implements Client_Interface
{

	public Client_Interface_Impl()
		throws RemoteException
	{
		super();
	}


	public String notifyMe(String message)
	{
		String return_Message = "Callback received: " + message;
		System.out.println(return_Message);

		return return_Message;
	}


	public int adder(int a, int b)
	{
		int sum = a + b;

		System.out.println("Sum = " + sum);

		return sum;
	}


} //End of public class Client_Interface_Impl;