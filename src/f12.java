import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f12 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_12.txt");
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        FileWriter fwr = new FileWriter(file1, true);
        String str = "";
        while (fread.ready()) {
            str += fread.readLine() + "\r\n";
        }

        String[] mas = { "[Ээ]й", "депутатик", "мужчинка", "сынок", "эй ", "депутатик ", "мужчинка ", "сынок ",
                "[Нн]у ", "будем говорить ", "[Зз]начит так ", "[Кк]ороче ", "[Тт]ипа ", "будем говорить",
                "[Зз]начит так",
                "короче", "типа", "\\s+\\s+" };
        for (int i = 0; i < mas.length; i++) {
            Pattern q1 = Pattern.compile(numb(mas, i));
            Matcher textDeda1 = q1.matcher(str);
            while (textDeda1.find()) {
                if (i <= 7) {
                    str = textDeda1.replaceAll("Алексей Генадьевич");
                } else if (i > 7 || i <= 16) {
                    str = textDeda1.replaceAll("");
                } else if (i == 17) {
                    str = textDeda1.replaceAll(" ");
                }
            }
        }
        String[] pp = str.split("\\s+");
        for (int j = 0; j < pp.length - 2; j++) {
            if (Objects.equals(pp[j], pp[j + 1])) {
                pp[j + 1] = "";
            } else if (Objects.equals(pp[j], pp[j + 2])) {
                pp[j + 2] = "";
            }
        }
        str = String.join(" ", pp);
        Pattern q1 = Pattern.compile(numb(mas, 17));
        Matcher textDeda1 = q1.matcher(str);
        str = textDeda1.replaceAll(" ");
        fwr.write("\n\nИсправленный текст:\nПисьмо Алексею Генадьевичу\n\n" + str);
        fwr.flush();
        fwr.close();
    }

    public static String numb(String[] m, int n) {
        return m[n];
    }
}
