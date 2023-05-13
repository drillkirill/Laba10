import java.io.*;
import java.lang.Double;
import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;

public class f14 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\User\\Desktop\\text_14.txt");
        File file2 = new File("C:\\Users\\User\\Desktop\\text_14.2.txt");
        BufferedReader fread = new BufferedReader(new FileReader(file1));

        FileWriter fwr2 = new FileWriter(file2);

        for (int i = 0; i < 12; i++) {// promotka informacii
            fread.readLine();
        }

        int cnt = 0;// для нахождения среднего значения
        Double maxX = -1000.0, minX = 1000.0, sumx = 0.0, srx = 0.0, maxY = -1000.0, minY = 1000.0, sumy = 0.0,
                sry = 0.0,
                maxZ = -1000.0, minZ = 1000.0, sumz = 0.0, srz = 0.0, maxXY = -1000.0, minXY = 1000.0, sumxy = 0.0,
                srxy = 0.0;

        while (fread.ready()) {
            String[] stroka = fread.readLine().split("-0\\.");
            for (int i = 1; i < stroka.length; i++) {
                stroka[i] = " -0." + stroka[i];
            }
            String line = vixod(stroka).replaceFirst("\\s+", "");
            String[] STRoka2 = line.split("\\s+");
            ;
            // sumVsex
            sumx += parseDouble(STRoka2[1]);
            sumy += parseDouble(STRoka2[2]);
            sumz += parseDouble(STRoka2[3]);
            sumxy += parseDouble(STRoka2[4]);

            // X
            if (parseDouble(STRoka2[1]) > maxX) {
                maxX = parseDouble(STRoka2[1]);
            }
            if (parseDouble(STRoka2[1]) < minX) {
                minX = parseDouble(STRoka2[1]);
            }

            // Y
            if (parseDouble(STRoka2[2]) > maxY) {
                maxY = parseDouble(STRoka2[2]);
            }
            if (parseDouble(STRoka2[2]) < minY) {
                minY = parseDouble(STRoka2[2]);
            }

            // Z
            if (parseDouble(STRoka2[3]) > maxZ) {
                maxZ = parseDouble(STRoka2[3]);
            }
            if (parseDouble(STRoka2[3]) < minZ) {
                minZ = parseDouble(STRoka2[3]);
            }

            // XY
            if (parseDouble(STRoka2[4]) > maxXY) {
                maxXY = parseDouble(STRoka2[4]);
            }
            if (parseDouble(STRoka2[4]) < minXY) {
                minXY = parseDouble(STRoka2[4]);
            }
            cnt++;

        }
        srx = sumx / cnt;
        sry = sumy / cnt;
        srz = sumz / cnt;
        srxy = sumxy / cnt;
        fwr2.write("\tМакс знач\tМин значение\tСреднее значение\n\n" +
                "X\t" + maxX + "\t" + minX + "\t\t" + srx + "\n" +
                "Y\t" + maxY + "\t" + minY + "\t\t" + sry + "\n" +
                "Z\t" + maxZ + "\t" + minZ + "\t\t" + srz + "\n" +
                "XY\t" + maxXY + "\t" + minXY + "\t\t" + srxy + "\n\n");

        fread.close();
        BufferedReader fread1 = new BufferedReader(new FileReader(file1));
        for (int i = 0; i < 12; i++) {// promotka informacii
            fread1.readLine();
        }
        Double xOtk = 0.0, yOtk = 0.0, zOtk = 0.0, xyOtk = 0.0;
        fwr2.write("\t\t\t\tПроцент отклонения\n" +
                "\tNODE\tEPPLX\tEPPLY\tEPPLZ\tEPPLXY\tEPPLYZ\tEPPLXZ\n");
        while (fread1.ready()) {// zapis otklonenia

            String[] stroka = fread1.readLine().split("-0\\.");
            for (int i = 1; i < stroka.length; i++) {
                stroka[i] = " -0." + stroka[i];
            }
            String line = vixod(stroka).replaceFirst("\\s+", "");
            String[] STRok = line.split("\\s+");

            xOtk = parseDouble(STRok[1]);
            yOtk = parseDouble(STRok[2]);
            zOtk = parseDouble(STRok[3]);
            xyOtk = parseDouble(STRok[4]);

            fwr2.write("\t" + STRok[0] + "\t" + otklon(xOtk, srx) + "%\t" + otklon(yOtk, sry) +
                    "%\t" + otklon(zOtk, srz) + "%\t" + otklon(xyOtk, srxy) +
                    "\t\t\s\s0" + "\t\t\s\s0" + "\n");
        }

        fwr2.flush();
        fwr2.close();
    }

    public static String otklon(double n, double m) {
        DecimalFormat mm = new DecimalFormat("##");
        return mm.format(abs(n / m * 100 - 100));
    }

    public static String vixod(String[] mas) {
        String fwe = "";
        for (int i = 0; i < mas.length; i++) {
            fwe += mas[i];
        }
        return fwe;
    }
}
