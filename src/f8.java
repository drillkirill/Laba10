import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class f8 {
    public static void main(String[] args) throws IOException {
        Scanner mc = new Scanner(System.in);
        Random rand = new Random();

        File file1 = new File("C:\\Users\\User\\Desktop\\text_8.txt");
        BufferedWriter fwr1 = new BufferedWriter(new FileWriter(file1));
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        fwr1.write("1-ая Фигура 1) 4>=(x+1)^2+(y+1)^2\tx>=-3 && x<=-1 y>=-1 && y<=3\r\n " +
                "\t\t2) y<=-1.5x+3.5 y>=3x-1 y>=-2x-1\ty>=-1 && y<=5 x>=-1 && x<=1\r\n" +
                "2-ая фигура 1) y>=x-7\tx>=4 &&x<=6\r\n" +
                "\t\t2) 4<=(x-4)^2+(y+1)^2 x>=2 && x<=4 y>=-3 && y<=-1\r\n" +
                "\t\t3) y<=x-3 x>=2 && x<=3 y>=-1 && y<=0\r\n" +
                "\t\t4) y>=-x+3 x>=2 && x<=3 y>=0 && y<=1\r\n" +
                "\t\t4<=(x-4)^2+(y+1)^2 x>=4 && x<=6 y>=-1 && y<=1\n\n" +
                "\tX\tY\n\n");

        System.out.println("Введите количество точек, программа их заполнит автоматически.");
        int n = mc.nextInt();

        for (int i = 0; i < n; i++) {
            int cnt = i + 1;
            fwr1.write(cnt + ")\t" + rand.nextInt(-4, 8) + "\t" + rand.nextInt(-4, 6) + "\r\n");
        }

        fwr1.write("\r\nВывод\r\n\r\n");
        fwr1.close();
        BufferedWriter fwr2 = new BufferedWriter(new FileWriter(file1, true));

        for (int i = 0; i < 10; i++) {
            fread.readLine();
        }
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            String[] mas = fread.readLine().split("\\s+");
            int x = Integer.parseInt(mas[1]), y = Integer.parseInt(mas[2]);
            int pop = FIGURE(x, y);

            if (pop == 2) {
                fwr2.write(cnt + ") Точка (" + x + ";" + y + ")\tПопала в область фигуры 2\r\n");
            }
            if (pop == 1) {
                fwr2.write(cnt + ") Точка (" + x + ";" + y + ")\tПопала в область фигуры 1\r\n");
            }
            if (pop == 0) {
                fwr2.write(cnt + ") Точка (" + x + ";" + y + ")\tНе попала в область\r\n");
            }
            if (pop == -1) {
                fwr2.write(cnt + ") Точка (" + x + ";" + y + ")\tПопала на границу фигуры 1\r\n");
            }
            if (pop == -2) {
                fwr2.write(cnt + ") Точка (" + x + ";" + y + ")\tПопала на границу фигуры 2\r\n");
            }
            cnt++;
        }
        fwr2.flush();
        fwr2.close();
    }

    public static int FIGURE(int x, int y) {
        if (fig_1(x, y) == 1) {
            return 1;
        } else if (fig_1(x, y) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static int fig_1(double x, double y) {
        double v1 = Math.pow(x + 1, 2) + Math.pow(y - 1, 2), v2 = Math.pow(x - 4, 2) + Math.pow(y + 1, 2);
        if (((x >= -1 & x <= 1 & y >= -1 & y <= 5 & y < -1.5 * x + 3.5 & y > 3 * x - 1 & y > -2 * x - 1) || // 1 фигура
                                                                                                            // 1 и 3
                                                                                                            // треуг
                (y >= -1 & y <= 3 & x >= -3 & x <= -1 & y < v1 & y > -v1))) {
            return 1;
        } // 1 фигура 2 полуокр

        else if ((((x >= 2 & x <= 4 & y >= 0 & y <= 1 & y > -x + 3) ||
                (x > 2 & x < 3 & y < 0 & y > -1 & y < x - 3) ||
                (y > x - 7 & x >= 4 & x <= 6 & y >= -3 & y <= -1) ||
                (x >= 2 & x <= 4 & y >= -3 & y <= -1 & y < -v2) ||
                (x >= 4 & x <= 6 & y >= -1 & y <= 1 & y < v2)))) {
            return 2;
        } // oblast

        else if ((x >= -1 & x <= 1 & y >= 2 & y <= 5 & y == -1.5 * x + 3.5) ||
                (y == 3 * x - 1 & y >= -1 & y <= 2 & x >= 0 & x <= 1) ||
                (x >= -1 & x <= 0 & y <= 1 & y >= -1 & y == -2 * x - 1) ||
                (x == -1 & ((y >= -1 & y <= 1) || (x >= 3 & x <= 5))) ||
                (x >= -3 & x <= -1 & y >= -1 & y <= 3 & 4 == v1)) {
            return -1;
        } // phigure

        else if ((x >= 2 & x <= 4 & y == 1) || (x >= 2 & x <= 4 & y <= -1 & y >= -3 & 4 == v2) ||
                (x > 4 & x <= 6 & y <= 1 & y >= -1 & 4 == v2) ||
                (x >= 4 & x <= 6 & y >= -3 & y <= -1 & y == x - 7) ||
                (x >= 2 & x <= 3 & y <= 1 & y >= 0 & y == -x + 3) ||
                (x >= 2 & x <= 3 & y <= 0 & y >= -1 & y == x - 3)) {
            return -2;
        } // phigure
        return 0;
    }
}
