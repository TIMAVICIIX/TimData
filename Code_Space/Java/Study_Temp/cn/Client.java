package cn;

import com.Server;

public class Client{

  	public static void main(String args[]){

		Client client=new Client();
		client.show();
	
	}

	public void show(){
	 	Server server=new Server();
	
		server.print();
	}


}