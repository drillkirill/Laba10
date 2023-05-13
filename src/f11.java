import java.io.*;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class f11 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_11.txt");
        BufferedWriter fwr = new BufferedWriter(new FileWriter(file1));
        fwr.write("Формула z = cos(x)*pow(x,4)*pow(y,2)+sin(x*y)\n" +
                "x>=-4 && x<=1 x+=0.1, y>=-1 && y<=4 y+=0.2\n\n" +
                " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tМатрица значений Z\n\n" +
                "Y/X\t");
        DecimalFormat mm = new DecimalFormat("#.#");

        for (Double x = -4.0; x <= 1.0; x += 0.1) {
            fwr.write(mm.format(x) + "\t");
        }
        for (Double y = -1.0; y <= 4.1; y += 0.2) {
            fwr.write("\n");
            fwr.write(mm.format(y) + "\t");
            for (double x = -4.0; x <= 1.0; x += 0.1) {
                Double z = cos(x) * pow(x, 4) * pow(y, 2) + sin(x * y);
                fwr.write(mm.format(z) + "\t");
            }

        }

        fwr.flush();
        fwr.close();
    }
}
