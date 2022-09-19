import java.util.*;

public class Matrix {

    private double arr[][];
    private int size_n, size_m;

    //конструктор по умолчанию
    Matrix() {
        arr = null;
        size_n = 0;
        size_m = 0;
    }

    //конструктор с параметрами
    Matrix (int n, int m) {
        size_n=n;
        size_m=m;
        arr = new double [size_n][size_m];
    }

    //метод доступа к элементу по индексам
    double getElement(int i, int j) {
        return arr[i][j];
    }

    //метод устанавилвает значение элемента
    void setElement(int i, int j, double value) {
        arr[i][j] = value;
    }

    //метод заполнение матрицы случайными значениями
    void randomize() {
        Random random = new Random();
        for (int i = 0; i < size_n; ++i) {
            for (int j = 0; j < size_m; ++j) {
                arr[i][j] = Math.floor(random.nextDouble() * 100)/10;
            }
        }
    }

    //метод ввода массива
    void scan(Scanner scanner) {
        System.out.printf("Заполните матрицу %dx%d: ", size_n, size_m);
        for (int i = 0; i < size_n; ++i) {
            for (int j = 0; j < size_m; ++j)
                arr[i][j] = scanner.nextDouble();
        }
    }

    //метод вывода массива
    void print(String string) {
        System.out.printf("Матрица %s:\n", string);
        for (int i = 0; i < size_n; ++i) {
            for (int j = 0; j < size_m; ++j)
                System.out.print(String.format("%.2f\t", arr[i][j]).replace(',', '.'));
            System.out.println("");
        }
    }

    //метод вывода массива с переносом строки
    void println(String string) {
        print(string);
        System.out.println();
    }

    //метод для получения суммы матриц
    Matrix add(Matrix other) throws Exception {
        Matrix temp = new Matrix(size_n,size_m);
        if (this.size_n != other.size_n || this.size_m != other.size_m) {
            throw new Exception(
                    String.format("Невозможно сложить матрицы разных размеров"));
        }
        for (int i = 0; i < size_n; ++i) {
            for (int j = 0; j < size_m; ++j)
                temp.arr[i][j] = this.arr[i][j] + other.arr[i][j];
        }
        return temp;
    }

    //метод для получения произведения матриц
    Matrix mult(Matrix other) throws Exception {
        Matrix temp = new Matrix(this.size_n, other.size_m);
        if (this.size_m != other.size_n) {
            throw new Exception(
                    String.format("Невозможно перемножить матрицы"));
        }
        for (int i = 0; i < this.size_n; ++i) {
            for (int j = 0; j < other.size_m; ++j) {
                temp.arr[i][j] = 0;
                for (int k = 0; k < this.size_m; ++k) {
                    temp.arr[i][j] += this.arr[i][k] * other.arr[k][j];
                }
            }
        }
        return temp;
    }

    //метод транспонирования массива
    Matrix trans() {
        Matrix temp = new Matrix(size_m, size_n);

        for (int i=0;i<size_n;i++) {
            for (int j=0;j<size_m;j++) {
                temp.arr[j][i] = arr[i][j];
            }
        }

        return temp;
    }




}