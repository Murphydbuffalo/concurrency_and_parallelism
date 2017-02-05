import java.util.Random;

public class Philosopher extends Thread {
	public class Chopstick extends Object {}
	private Chopstick first, second;
	private Random random;
	public Philosopher(Chopstick leftChopstick, Chopstick rightChopstick) {
		if (System.identityHashCode(leftChopstick) < System.identityHashCode(rightChopstick)) {
			first = leftChopstick;
			second = rightChopstick;
		} else {
			first = rightChopstick;
			second = leftChopstick;
		}
		
		random = new Random();
	}

	public void run() {
		try {
			while(true) {
				// The philosopher is thinking, and not eating...
				Thread.sleep(random.nextInt(1000));
				synchronized(first) {
					synchronized(second) {
						// The philosopher is eating, and not thinking...
						Thread.sleep(random.nextInt(1000));
					}
				}
			}
		} catch(InterruptedException e) { System.out.println(String.format("Error is %s", e)); };

	}

}
