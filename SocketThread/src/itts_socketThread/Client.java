package itts_socketThread;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;



public class Client {
	Socket socket;
	InetAddress ip; 
	int porta; 
	
	public Client(InetAddress ip, int porta) {
		
		this.ip=ip;
		this.porta=porta; 
		
	}
	
	
	
	public void connessione() {
		try {
			socket= new Socket();
			InetSocketAddress isa = new InetSocketAddress(ip, porta);
			socket.connect(isa, 25000);
			
			System.out.println("Client avviato con successo"); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void chiusura() {
		try {
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String leggi() {
		String timeOut = null;
		Scanner sc; 
		try {
			sc=new Scanner(socket.getInputStream());
			timeOut=sc.nextLine();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return timeOut; 
	} 

	public void scrivi() {
	try {
		  
		Scanner in=new Scanner(System.in); 
		
		System.out.println("inserisci la password per ricevere la data");
		String messaggio=in.nextLine(); 
		messaggio += "\n";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
		dos.writeBytes(messaggio);
		
		
	}  catch (IOException e) {
		e.printStackTrace();
	}

	}
	
	public void riceviData() {
		Scanner sc; 
		String data; 
		try {
			sc=new Scanner(socket.getInputStream());
			data=sc.nextLine();  
			System.out.print("Data attuale: "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


}
