package com.hreshi.rawchat;

import java.net.Socket;
import java.lang.Runnable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpRequest{
	private Socket conn;
	private String request = "";
	BufferedReader reader;
	HttpRequest(Socket sock) {
		conn = sock;
		try {
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void readRequest() {
		while(true) {
			try {
				String line = reader.readLine();
				request += "\n"+line;
				if(line.equals("")) {
					break;
				}
			} catch(Exception e) {
				request = "Something went wrong";
			}
		}
	}
	public String toString() {
		return request;
	}
}