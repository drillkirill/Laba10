import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class f9 {
    public static File file1 = new File("C:\\Users\\User\\Desktop\\text_9.txt");
    public static FileWriter fwr;

    static {
        try {
            fwr = new FileWriter(file1, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        ArrayList<String> Array = new ArrayList<String>();
        while (fread.ready()) {
            Array.add(fread.readLine());
        }
        String[][] masStrok = new String[Array.size()][];
        for (int i = 0; i < Array.size(); i++) {
            String m = String.valueOf(Array.get(i));
            masStrok[i] = m.split(";");
        }
        fwr.write("\r\n\r\nВывод ответа\r\n\r\nКоличество изданий по городам\r\n\r\n");
        find_information(masStrok);
        fwr.flush();
        fwr.close();
        fread.close();
    }

    public static void find_information(String[][] ma) throws IOException { // Метод который ищет нужные данные об
                                                                            // издательствах
        String[][] mas = ma;
        String STR = "";
        int k = 1, cnt = 0, cntNagrad = 0, cntPoryadok = 0, cntOsn = 0, cntAvtory = 0, cntMagaz = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int z = 0; z < 10; z++) {// кол-во издательств с цифрами
                if (mas[i][2].contains(String.valueOf(z))) {
                    cnt++;
                    break;
                }
            }
            if (Objects.equals(mas[i][16], "Есть")) {// nagrady
                cntNagrad++;
            }
            if (Integer.parseInt(mas[i][4]) >= 1970 & Integer.parseInt(mas[i][4]) <= 2000) {// god_osn
                cntOsn++;
            }
            if (Integer.parseInt(mas[i][15]) >= 1 & Integer.parseInt(mas[i][17]) >= 10) {// nagrady i magazin
                cntMagaz++;
            }
            if (Integer.parseInt(mas[i][5]) / Integer.parseInt(mas[i][8]) >= 0.1) {// Otnoshenie
                cntAvtory++;
            }
            String chis1 = Integer.toString(Integer.parseInt(mas[i][9]) / (2023 - Integer.parseInt(mas[i][4]))),
                    chis2 = mas[i][12];
            if (chis2.length() == chis1.length()) {
                cntPoryadok++;
            }
            STR = mas[i][0];
            STR = "";
            k = 1;
            if (!mas[i][0].equals("")) {// cifri
                STR = "";
                k = 1;
                STR = mas[i][0];
                for (int j = i + 1; j < mas.length; j++) {
                    if (STR.equals(mas[j][0])) {
                        mas[j][0] = "";
                        k++;
                    }
                }
                mas[i][0] = "";
                fwr.write(STR + "\t" + k + "\r\n");
            }
        }
        fwr.write("\r\nКоличество изданий, содержащих цифры в названии " + cnt + "\r\n");
        fwr.write("Количество изданий, среднее количество выпускаемых книг в год того же порядка," +
                " что и средняя стоимость 1-ой книги " + cntPoryadok + "\r\n");
        fwr.write("Количество изданий, иимеющих награды " + cntNagrad + "\r\n");
        fwr.write("Количество изданий, с отношением кол-ва сотрудников к авторам меньшим 0.1 " + cntAvtory + "\r\n");
        fwr.write("Количество изданий, основанных в [1970;2000] " + cntOsn + "\r\n");
        fwr.write(
                "Количество изданий, имеющих хотя бы 1 собственный магазин и не менее 10 наград " + cntMagaz + "\r\n");

    }
}
