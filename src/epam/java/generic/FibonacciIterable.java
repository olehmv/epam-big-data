package epam.java.generic;

import java.util.Iterator;

public class FibonacciIterable implements Iterable<Integer>{
	private int n;
	private Fibonacci fibo;

	public FibonacciIterable(int n, Fibonacci fibo) {
		this.n = n;
		this.fibo = fibo;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n>0;
			}

			@Override
			public Integer next() {
				n--;
				return fibo.next();
			}
		};
	}
	public static void main(String ...a){
		FibonacciIterable fibo=new FibonacciIterable(8, new Fibonacci());
		for (Integer integer : fibo) {
			System.out.println(integer);
		}
	}

}
