package itts_socketThread;

import java.io.DataOutputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Server {
	ServerSocket serverSocket; 
	Socket socket; 
	Countdown cd = new Countdown(25);
	
	int porta; 
	
	public Server(int porta) {
		try {
			this.porta=porta; 
			serverSocket = new ServerSocket(porta);
			System.out.println("Server in ascolto");
			serverSocket.setSoTimeout(25000);
			cd.start();	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public Socket connessione() {
	try {
		socket=serverSocket.accept();
		cd.stopThread(); 
		System.out.println("client connesso");
		
	} catch (IOException e) {
		System.out.println("Comunicazione non avviata");
	}
	return socket; 
}

public void chiusura() {
	
	try {
		serverSocket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	public void leggi() {
		Scanner sc;
		String pwd="ciao\n"; 
		try {
			sc=new Scanner(socket.getInputStream());
			String risposta=sc.nextLine(); 
			System.out.print(risposta);
			if(risposta==pwd) {
				System.out.println("Corrisponde");
			} else {
				Long datetime = System.currentTimeMillis();
				SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		        String timeStamp = date.format(new Date(datetime));
		        timeStamp+="\n";
		        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
				dos.writeBytes(timeStamp);		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} 

	public void scrivi() {
		try {
	  
			String timeOut=30+"\n"; 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
			dos.writeBytes(timeOut);
	
	
		}  catch (IOException e) {
			e.printStackTrace();
		}

	} 

	
}
