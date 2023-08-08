import java.util.stream.LongStream;
import java.util.Arrays;
import java.math.BigInteger;

import javax.swing.JFrame;

// external dependencies
import com.fasterxml.jackson.databind.ObjectMapper;

public class SuperProgram {
	public static void main(String... args) {
		javaBaseCode(Integer.MAX_VALUE + 10L);
		jackson();
		javaDesktop();
	}

	public static void javaBaseCode(long n) {
		BigInteger n1 = BigInteger.valueOf(n);
		BigInteger gauss = n1.multiply(n1.add(BigInteger.ONE)).shiftRight(1);
		BigInteger naive = LongStream.rangeClosed(1, n)
			.parallel()
			.mapToObj(e -> BigInteger.valueOf(e))
			.reduce(BigInteger.ZERO, (sum, el) -> sum.add(el), (sum, el) -> sum.add(el));
		System.out.println(gauss + " == " + naive);
	}

	public static void javaDesktop() {
		JFrame root = new JFrame("Hello World");
                root.setExtendedState(JFrame.MAXIMIZED_BOTH);
                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setVisible(true);
	}

	public static void jackson() {
		String s = new ObjectMapper().writeValueAsString(
			Arrays.asList("Y", "las", "...", "llovían", "llovían", "...")
		);
		System.out.println(s);
	}
}
