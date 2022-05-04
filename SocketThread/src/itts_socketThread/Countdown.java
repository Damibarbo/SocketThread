package itts_socketThread;

public class Countdown extends Thread {
	
	private int lifeTime; 
	private boolean interrotto=false;  
	
	public Countdown(int lifeTime) {
		this.lifeTime=lifeTime; 
	}
	
	@Override
	public void run() {
		
		while(lifeTime>=0) {
			if(!interrotto) {
				System.out.println(lifeTime);
				lifeTime=lifeTime-1; 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void stopThread() {
		interrotto=true; 
	}

}
