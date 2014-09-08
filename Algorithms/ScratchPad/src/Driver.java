
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long nano = System.nanoTime();
		Fib fib = new Fib();
		
		for(int i = 0; i < 100; i++) {
			nano = System.nanoTime();
			System.out.print("Index: " + i + " Num: " + fib.fib(i) + " Time: ");
			System.out.print((System.nanoTime() - nano) / 1000000);
			System.out.println();
		}

	}

}
