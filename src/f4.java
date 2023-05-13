import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class f4 {
    public static void main(String[] args) throws IOException {

        File file1 = new File("C:\\Users\\User\\Desktop\\text_4.txt");
        File file2 = new File("C:\\Users\\User\\Desktop\\text_4.2.txt");
        FileWriter fWr2 = new FileWriter(file2);
        FileReader fRead = new FileReader(file1);
        BufferedReader buffR = new BufferedReader(fRead);

        Pattern pat = Pattern.compile("[1234567890УЕЫАЭЯЮA-Za-z&&[^AEYOUI]]+");
        Matcher matc;
        String line;
        String[] mas_line;
        while (buffR.ready()) {

            line = buffR.readLine();
            mas_line = line.split("[\\s_\\.,:;\\?!\\t]+");
            for (int i = 0; i < mas_line.length; i++) {
                matc = pat.matcher(mas_line[i]);
                if (matc.find()) {
                    fWr2.write(mas_line[i] + "\n");
                }
            }
        }
        fWr2.flush();
        fWr2.close();
    }
}
