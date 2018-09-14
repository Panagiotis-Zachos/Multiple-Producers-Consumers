package mlpc;

import java.util.Random;

public class Producer implements Runnable{

	private Number[] st;
	private static int point = 0;
	private Random rand = new Random();
	
	public Producer(Number[] st) {
		this.st = st;
	}
	
	@Override
	public void run() {

		Number num = 0;
		while(true) {
			try {
				
				MPCMain.P.acquire();
				MPCMain.Writes.acquire();
				switch(rand.nextInt(3)) {
				case 0:
					num = this.rand.nextInt();
					break;
				case 1:
					num = this.rand.nextDouble();
					break;
				case 2:
					num= this.rand.nextLong();
					break;
				}
				this.st[Producer.point] = num;
				Producer.point = (Producer.point + 1) % 10;
				PCGui.pText.append(num.toString() + "\n");
				MPCMain.Reads.release();
				MPCMain.P.release();
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
