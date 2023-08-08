import javax.swing.*;
import javax.sql.*; // actually not used, but I want to show javac removes it anyway

public class HelloSwing {
        public static void main(String... args) {
                JFrame root = new JFrame("Hello World");
                root.setExtendedState(JFrame.MAXIMIZED_BOTH);
                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setVisible(true);
        }
}
