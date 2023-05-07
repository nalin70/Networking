package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket s = new  Socket("localhost", 898);
		
		//read from console
		System.out.println("Enterthe message to the server: ");
		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(isr);
		
		String cmsg = br.readLine();
		
		OutputStream os = s.getOutputStream();
		PrintStream ps = new PrintStream(os);
		
		//writing to socket
		ps.println(cmsg);
		
		//read from socket
		InputStream is = s.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(is);
		BufferedReader br1 = new BufferedReader(isr1);
		
		String smsg = br1.readLine();
		
		//writing to console
		System.out.println("Message from server is: "+ smsg);
		
		ps.close();
		s.close();
	}
}
