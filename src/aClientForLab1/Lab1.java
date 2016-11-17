package aClientForLab1;

import java.io.*;
import java.net.*;

public class Lab1 {
	
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args) {
		Lab1 client = new Lab1();
		client.go();
	}
	
	public void go() {
		
		try {
			String host = "localhost";
			//String path = "/~ebarrett/lectures/cs4032/echo.php?message=mingdarui";
			String path = "/echo.php?message=mingdarui";
			String responseMsg;
			sock = new Socket(host, 8000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			
	        writer.print("GET " + path + " HTTP/1.1\r\n");  
	        writer.print("Host: " + host + "\r\n");  
	        writer.print("\r\n");
	        writer.flush();  
			
	        responseMsg = reader.readLine();
			System.out.println("succeed!: " + responseMsg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
