import java.io.*;
import java.util.Arrays;

public class f5 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_5.txt");
        File file2 = new File("C:\\Users\\User\\Desktop\\text_5.2.txt");

        BufferedReader fread = new BufferedReader(new FileReader(file1));
        FileWriter fwr2 = new FileWriter(file2, true);
        StringBuilder str = new StringBuilder();

        while (fread.ready()) {
            str.append(fread.readLine().replaceAll("\r\n", ""));
        }
        String[] mas = String.valueOf(str).split("\\.");
        for (int i = 0; i < mas.length; i++) {
            String[] masStrok = mas[i].split("\\s+");

            for (int j = 0; j < masStrok.length; j++) {
                if (masStrok[j].equals(revers(masStrok[j]))) {
                    fwr2.write(prin(masStrok));
                    break;
                }
            }
        }
        fwr2.flush();
        fwr2.close();
    }

    public static String revers(String str) {
        if (str.length() > 2) {
            return new StringBuilder(str).reverse().toString();
        }
        return "";
    }

    public static String prin(String[] mas) {
        StringBuilder hj = new StringBuilder();
        for (int i = 0; i < mas.length; i++) {
            if (i != mas.length - 1) {
                hj.append(mas[i] + "\s");
            } else
                hj.append(mas[i] + ".\s");
        }
        return String.valueOf(hj);
    }
}
