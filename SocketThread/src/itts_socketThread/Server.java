package itts_socketThread;

import java.io.DataOutputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	ServerSocket serverSocket; 
	Socket socket; 
	Countdown cd = new Countdown(25);
	
	int porta; 
	
	public Server(int porta) {
		this.porta=porta; 
	}
	
public void connessione() {
	try {
		serverSocket = new ServerSocket(porta);
		System.out.println("Server in ascolto");
		serverSocket.setSoTimeout(25000);
		cd.start();
		socket=serverSocket.accept();
		cd.stopThread(); 
		System.out.println("richiesta client con successo");
		
	} catch (IOException e) {
		System.out.println("Comunicazione non avviata");
	}
	
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
		try {
			sc=new Scanner(socket.getInputStream());
			String risposta=sc.nextLine(); 
			risposta +="\n"; 
			System.out.println("Client: " + risposta); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} 

	public void scrivi() {
		try {
	  
			Scanner in=new Scanner(System.in); 
	
			System.out.println("inserisci il messaggio da mandare al client");
			String messaggio=in.nextLine(); 
			messaggio += "\n";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
			dos.writeBytes(messaggio);
	
	
		}  catch (IOException e) {
			e.printStackTrace();
		}

	} 

	
}
