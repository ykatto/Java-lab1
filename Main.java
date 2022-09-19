import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Matrix m1 = new Matrix(3, 3);
        m1.randomize();
        m1.println("A");
        m1.trans().println("транспонированная A");

        Matrix m2 = new Matrix(3, 3);
        m2.randomize();
        m2.println("B");

        m1.add(m2).println("A+B");
        m1.mult(m2).println("A*B");
    }
}