import java.io.*;
import java.text.DecimalFormat;
import static java.lang.Math.*;

public class f7 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_7.txt");
        FileWriter fwr1 = new FileWriter(file1);
        fwr1.write(
                "Постановка задачи \r\rx>=-3 && x<=3 x+=0.5 \r\nf(x)=sin(2*PI*x)-cos(2*PI*x)  x+=0.5 \r\nf(x)=3+PI*x\r\n\r\n"
                        +
                        "Вывод данных \r\n\r\n");
        for (double i = -3.0; i <= 3.0; i += 0.5) {
            DecimalFormat mm = new DecimalFormat("#.#");
            if (i >= -3.0 && i < 0.0) {
                double m = 3 * PI * i;
                fwr1.write("f(" + i + ")=" + mm.format(m) + "\s\s");
            } else {
                double m = sin(2 * PI * i) - cos(2 * PI * i);
                fwr1.write("f(" + i + ")=" + mm.format(m) + "\s\s");
            }
        }
        fwr1.flush();
        fwr1.close();
    }
}
