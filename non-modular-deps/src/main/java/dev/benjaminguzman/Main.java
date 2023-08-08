package dev.benjaminguzman;

import io.nats.client.Connection;
import io.nats.client.Nats;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String... args) throws IOException, InterruptedException {
		try (Connection conn = Nats.connect("nats://127.0.0.1:4222")) {
			conn.createDispatcher(msg -> {
				BigInteger n = new BigInteger(new String(msg.getData(), StandardCharsets.UTF_8));
				System.out.println("sum1toN(" + n + ") = " + sum1toN(n));
			}).subscribe("numbers.gauss");
			new CountDownLatch(1).await();
		}
	}

	public static BigInteger sum1toN(BigInteger n) {
		// n * (n + 1) / 2
		return n.multiply(n.add(BigInteger.ONE))
			.shiftRight(1);
	}
}