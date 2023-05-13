import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f3 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_3.txt");
        FileWriter fWr = new FileWriter(file1, true);
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        StringBuilder str_Ispr = new StringBuilder();
        String patt1 = "\\d+[a-zA-Z]+\\d+(\\r\\n)?|\\d+[а-яА-Я]+\\d+(\\r\\n)?";

        while (fread.ready()) {
            StringBuilder str = new StringBuilder();
            String[] mas_str;
            String line = fread.readLine();

            str.append(line).append(System.lineSeparator());
            mas_str = String.valueOf(str).split(" ");

            for (int i = 0; i < mas_str.length; i++) {
                Pattern patt = Pattern.compile(patt1);
                String k = mas_str[i].replaceAll("\r\n", "");
                Matcher matt = patt.matcher(k);
                if (matt.find()) {
                    str_Ispr.append(k + " ");
                }
            }
        }
        // Заполнение Файла словами
        fWr.write("\n\n" + "Слова между цифр " + "\r\n\r\n" + str_Ispr);
        fWr.flush();
        fWr.close();
    }
}
