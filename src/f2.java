import java.io.*;;

public class f2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_2.txt");
        FileWriter fWr = new FileWriter(file1);
        double a;
        double res;
        for (double i = 1; i <= 9; i++) {
            for (double j = 1; j <= 9; j++) {
                res = j / i;
                a = res * 10;
                res = a / 10;
                fWr.write((int) j + "/" + (int) i + "=" + String.format("%.3f", res) + "\t");
            }
            fWr.write("\n\n");
        }
        fWr.flush();
        fWr.close();
    }

}
