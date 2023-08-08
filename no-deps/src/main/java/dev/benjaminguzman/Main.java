package dev.benjaminguzman;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Arrays.stream(args)
			.map(BigInteger::new)
			.forEach(
				n -> System.out.println(
					"sum1toN(" + n + ") = " + sum1toN(n)
				)
			);
	}

	public static BigInteger sum1toN(BigInteger n) {
		// n * (n + 1) / 2
		return n.multiply(n.add(BigInteger.ONE))
			.shiftRight(1);
	}
}
