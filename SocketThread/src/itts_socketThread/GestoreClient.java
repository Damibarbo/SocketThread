package itts_socketThread;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GestoreClient {
	
public static void main(String[] args) {
	
		
		Client cl;
		try {
			cl = new Client(InetAddress.getLocalHost(),2000);
			cl.connessione();
			String tempo=cl.leggi(); 
			Countdown cd=new Countdown(Integer.parseInt(tempo)); 
			cd.start();
			cl.scrivi(); 
			cl.riceviData();
			//cl.chiusura();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
}

}
