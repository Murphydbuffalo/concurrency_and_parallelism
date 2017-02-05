
public class Counter {
	private int count = 0;
	// No synchronization leads to "lost updates"
	// Eg, both threads read the same value of `count` from memory
	// Then both threads increment that value and write `count` back to memory.
	// This means that where `count` should be increased by 2, it is only increased by 1.
	// public void increment() { ++count; }
	// public int getCount() { return count; }
	
	// Synchronizing values means that only 1 thread at a time is granted a lock
	// to a given variable in memory. These locks are referred to as mutexes, which
	// stands for "mutual exclusion".
	public synchronized void increment() {  ++count; }
	public synchronized int getCount() { return count; }
}
