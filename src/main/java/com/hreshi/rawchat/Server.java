package com.hreshi.rawchat;

import java.net.ServerSocket;
import java.io.IOException;
import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;

public class Server {
	int PORT = 8080;
	ServerSocket serverSock;
	List<Thread> threadList = new ArrayList<Thread>();

	private Server() {
		try {
			serverSock = new ServerSocket(PORT);
		} catch(Exception e) {
			System.out.println(e);
			System.exit(-1);
		}
	}

    public static void main( String[] args ) {
        Server s = new Server();
        System.out.println("Server listening on port : " + s.PORT);

        s.run();
    }
    private void run() {
    	while(true) {
        	try {
        		Thread t = new Thread(new RequestHandler(serverSock.accept()));
        		threadList.add(t);
        		t.start();
        	} catch(IOException ex) {
        		System.out.println(ex);
        	}
        }
    }
}
