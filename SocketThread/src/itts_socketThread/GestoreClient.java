package itts_socketThread;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GestoreClient {
	
public static void main(String[] args) {
	
		
		Client cl;
		try {
			cl = new Client(InetAddress.getLocalHost(),2000);
			cl.connessione();
			//cl.chiusura();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
}

}
