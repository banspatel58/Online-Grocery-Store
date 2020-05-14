package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Controller.StoreServerInterface;

public class Server{
	
	public static void main(String[] args) {		

		try {
			
			DatabaseConnection connection = new DatabaseConnection();
			
			//create the remote server and register as server using registry
			StoreServerInterface remoteStore = new RemoteDatabaseLookup(connection);
			
			String host = args[0];
	        int port = Integer.parseInt(args[1]);

	        String name = "//"+host+":"+port+"/OnlineGroceryStore";

	        Registry registry = LocateRegistry.getRegistry(port);
	        registry.rebind(name,remoteStore);
			
			System.out.println("Admin Server is ready.....");
			
		}catch(Exception e) {
			
			System.out.println("Server err: " + e.getMessage());
		    e.printStackTrace();			
				
		}
		
	}
	
}