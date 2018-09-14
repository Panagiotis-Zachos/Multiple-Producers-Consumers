package mlpc;

import java.util.concurrent.Semaphore;

public class MPCMain {

	public static Semaphore P = new Semaphore(1);
	public static Semaphore Writes = new Semaphore(10);
	public static Semaphore Reads = new Semaphore(0);
	public static Semaphore C = new Semaphore(1);
	
	public static Number[] st = new Number[10];
	public static int pointP = 0;
	public static int pointC = 0;
	
	public static void main(String[] args) {
				
		PCGui gui = new PCGui(st);
		
	}
}
