package com.hreshi.rawchat;

import java.net.Socket;
import java.lang.Runnable;
import java.io.PrintWriter;

public class HttpResponse{
	private Socket conn;
	PrintWriter writer;
	HttpResponse(Socket sock) {
		conn = sock;
		try {
			writer = new PrintWriter(conn.getOutputStream(), true);
		} catch(Exception e) {
			
		}
	}
	public void send(String request) {
		writer.println(request);
		try {
			writer.println(request);
			conn.close();
		} catch(Exception e) {

		} 
	}
}