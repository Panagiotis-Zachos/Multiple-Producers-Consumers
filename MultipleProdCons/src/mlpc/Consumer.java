package mlpc;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer implements Runnable{
	
	private Number[] st;
	private static int point = 0;
	private Queue<Number> q = new LinkedList<>();
	
	public Consumer(Number[] st) {
		this.st = st;

	}

	@Override
	public void run() {
		while(true) {
			try {
				
				MPCMain.Reads.acquire();
				MPCMain.C.acquire();
				PCGui.cText.append(this.st[Consumer.point] + "\n");
				Consumer.point = (Consumer.point + 1) % 10;
				MPCMain.C.release();
				MPCMain.Writes.release();
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
