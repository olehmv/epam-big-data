package epam.java.generic;

import java.util.Iterator;

public class Fibonacci implements Generator<Integer>{
	int count=0;

	@Override
	public Integer next() {
		return fibo(count++);
	}
	public int fibo(int n){
		if(n<2)return 1;
		return fibo(n-2)+fibo(n-1);
	}

}
