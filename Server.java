package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(898);
		Socket s = ss.accept();
		
		System.out.println("Connetction get");
		InputStream is = s.getInputStream();
		
		//read from socket
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String cmsg = br.readLine();
		
		//writing to the console
		System.out.println("MSG from client is: "+cmsg);
		
		//read from console
		System.out.println("Enter the message for the client: ");
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);
		
		String smsg = br1.readLine();
		
		//write to socket
		OutputStream os = s.getOutputStream();
		PrintStream ps = new PrintStream(os);
		ps.println(smsg);
		
	}
}

