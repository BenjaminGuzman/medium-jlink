package dev.benjaminguzman;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		Map<BigInteger, BigInteger> results = Arrays.stream(args)
			.map(BigInteger::new)
			.collect(HashMap::new, (map, n) -> map.put(n, sum1toN(n)), HashMap::putAll);
		System.out.println(new ObjectMapper().writeValueAsString(results));
	}

	public static BigInteger sum1toN(BigInteger n) {
		// n * (n + 1) / 2
		return n.multiply(n.add(BigInteger.ONE))
			.shiftRight(1);
	}
}