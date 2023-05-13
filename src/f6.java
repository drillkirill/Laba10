import java.io.*;
import java.text.DecimalFormat;

public class f6 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_6.txt");
        FileReader fr = new FileReader(file1);
        BufferedReader fread = new BufferedReader(fr);
        FileWriter fWr = new FileWriter(file1, true);

        Double srTEMP = 0.0, srOsadki = 0.0;
        String line = fread.readLine();
        fWr.write("\n\nРезультаты измерений\n\n");
        int k = 1, cnt = 0;
        Double visTemp = -100.0, niztemp = 100.0;
        String visGor = null, nizGor = null;

        DecimalFormat mm = new DecimalFormat("#.####");
        while (fread.ready()) {
            String[] mas = line.split("\\,|\\r\\n");
            srOsadki += Double.parseDouble(mas[3]);
            srTEMP += Double.parseDouble(mas[2]);
            if (Double.parseDouble(mas[2]) < niztemp) {
                niztemp = Double.parseDouble(mas[2]);
                nizGor = mas[0];
            }
            if (Double.parseDouble(mas[2]) > visTemp) {
                visTemp = Double.parseDouble(mas[2]);
                visGor = mas[0];
            }

            if (cnt % 11 == 0 & cnt != 0) {
                Double m = srOsadki / 12;
                Double c = srTEMP / 12;

                fWr.write(k + ") " + mas[0] + " Среднегодовые осадки = " + mm.format(m)
                        + " Среднегодовая температура = " + mm.format(c) + "\r\n\r\n");
                srTEMP = 0.0;
                srOsadki = 0.0;
                cnt = 0;
                k++;
            }
            line = fread.readLine();
            cnt++;
        }
        fWr.write("Максимальная температура среди городов " + visGor + " " + visTemp + "\n" +
                "Минимальная температура среди городов " + nizGor + " " + mm.format(niztemp));
        fWr.flush();
        fread.close();
        fWr.close();
    }
}