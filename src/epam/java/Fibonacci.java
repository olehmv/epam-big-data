package epam.java;

import java.util.Arrays;

public class Fibonacci {
	private int first = 0;
	private int second = 1;
	private int[] sequence;
	private int even;
	private int odd;
	private String correlation;

	public Fibonacci(int n) {
		this.setSequence(new int[n]);
		recursiveCalculation(n);
	}

	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci(20);
		Arrays.stream(fibo.getSequence()).forEach(System.out::println);
		System.out.println(fibo.oddEvenСorrelation());
		System.out.println("13 => " + fibo.findNumberByIndex(13));
		// int [] a=new int [1000];
		// loopCalculation(1000, a);
		// Arrays.stream(a).forEach(System.out::println);
	}

	public int recursiveCalculation(int n) {
		int next = 0;
		if (n == 1) {
			next = first;
		}
		if (n == 2) {
			next = second;
		}
		if (n > 2) {
			int fn = recursiveCalculation(n - 1);
			int sn = recursiveCalculation(n - 2);
			next = fn + sn;
		}
		sequence[n - 1] = next;
		return next;
	}

	public int findNumberByIndex(int index) {
		return sequence[index - 1];
	}

	public String oddEvenСorrelation() {
		for (int i : sequence) {
			if (i % 2 == 0) {
				++even;
			} else {
				++odd;
			}
		}
		float oddd = odd * 100 / sequence.length;
		float evenn = even * 100 / sequence.length;
		correlation = "odd: " + String.format("%.0f%%", oddd) + " even: " + String.format("%.0f%%", evenn);
		return correlation;
	}

	public static void loopCalculation(int n, int[] sequence) {
		int first = 0;
		int second = 1;
		int next = 0;
		int i = 0;
		while (n > 0) {
			sequence[i++] = next;
			first = second;
			second = next;
			next = first + second;
			n--;
		}
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int[] getSequence() {
		return sequence;
	}

	public String getCorrelation() {
		return correlation;
	}

	private void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	// public static void main(String[] args)
	// {
	// int index = 0;
	// int p=49;
	// while (p!=0)
	// {
	// System.out.println(fibonacci(index));
	// index++;
	// p--;
	// }
	// }
	// public static long fibonacci (int i)
	// {
	// if (i == 0) return 0;
	// if (i<= 2) return 1;
	//
	// long fibTerm = fibonacci(i - 1) + fibonacci(i - 2);
	// return fibTerm;
	// }

}
