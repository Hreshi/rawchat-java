package com.hreshi.rawchat;

import java.net.Socket;
import java.lang.Runnable;


public class RequestHandler implements Runnable{
	private Socket conn;
	public RequestHandler(Socket sock) {
		conn = sock;
	} 
	public void run() {
		System.out.println("User connected : " + conn.toString());
		HttpRequest request = new HttpRequest(conn);
		request.readRequest();
		String requestString = request.toString();
		HttpResponse response = new HttpResponse(conn);
		response.send(requestString);
		// write request.toString() to sock
	}
}