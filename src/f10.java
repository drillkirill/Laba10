import java.io.*;
import java.util.Scanner;

public class f10 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Users\\Desktop\\text_10.txt");
        Scanner mc = new Scanner(System.in);
        FileWriter fwr = new FileWriter(file1);

        System.out.println("Введите значение x,где  х < 1 and х > 0!!!");
        double x = mc.nextDouble();
        while (x >= 1) {
            if (x < 1 & x >= 0) {
                break;
            } else {
                System.out.println("Введите число меньше 1!!!");
                x = mc.nextDouble();
            }
        }
        int n = 0;
        double s = 0;
        for (double ep = 0.0001; ep <= 0.01; ep *= 10) {
            s = 0;
            n = 0;
            while (Math.abs(Math.atan(x) - s) > ep) {
                s += Math.pow(-1, n) * ((Math.pow(x, 2 * n + 1)) / (2 * n + 1));
                n++;
            }
            fwr.write("Функция f(x) = arctg(x) для x = " + x + " равняется " + s + "\n" +
                    "Результаты определения значений функции f(x) = arctg(x) с помощью ряда Маклорена\n" +
                    "Погрешность итерационной процедуры " + ep + "\n" +
                    "Значение функции по Маклорену\t\tПогрешность, %\tЧисло итераций\n" +
                    "\t\t" + s + "\t\t" + ep * 100 + "\t\t\t" + n + "\n\n");
        }
        fwr.flush();
        fwr.close();
    }
}
