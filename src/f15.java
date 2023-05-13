import java.io.*;
import java.util.Objects;

public class f15 {
    public static void main(String[] args) {
        try {

            File territoryFile = new File("C:\\Users\\User\\Desktop\\text_15.txt");
            File resultFile = new File("C:\\Users\\User\\Desktop\\text_15.2.txt");

            BufferedReader territoryReader = new BufferedReader(new FileReader(territoryFile));
            FileWriter resultWriter = new FileWriter(resultFile);

            String territoryLine;
            territoryReader.readLine(); // пропуск 1 строки
            int numb = 1;
            resultWriter.write("№ участка   Площадь участка   Кол-во объектов   Площадь дома   Площадь бани\n");
            while (territoryReader.ready()) {
                double y11 = 0.0, x11 = 0.0, x21 = 0.0, y21 = 0.0, x31 = 0.0, y31 = 0.0, x41 = 0.0, y41 = 0.0;
                int Count = 0;
                double area = 0.0, area_home = 0.0, area_Parilka = 0.0;

                territoryLine = territoryReader.readLine();
                String[] mas = territoryLine.split("\\s+");
                for (int i = 0; i < mas.length; i++) {
                    String[] territoryCoords = mas[i].split("[\\);]");
                    double x1 = Double.parseDouble(territoryCoords[1]);
                    double y1 = Double.parseDouble(territoryCoords[2]);
                    double x2 = Double.parseDouble(territoryCoords[3]);
                    double y2 = Double.parseDouble(territoryCoords[4]);
                    double x3 = Double.parseDouble(territoryCoords[5]);
                    double y3 = Double.parseDouble(territoryCoords[6]);
                    double x4 = Double.parseDouble(territoryCoords[7]);
                    double y4 = Double.parseDouble(territoryCoords[8]);

                    if (Objects.equals(territoryCoords[0], "1")) {
                        area = Area(x1, y1, x2, y2, x3, y3, x4, y4);
                        x11 = Double.parseDouble(territoryCoords[1]);
                        y11 = Double.parseDouble(territoryCoords[2]);
                        x21 = Double.parseDouble(territoryCoords[3]);
                        y21 = Double.parseDouble(territoryCoords[4]);
                        x31 = Double.parseDouble(territoryCoords[5]);
                        y31 = Double.parseDouble(territoryCoords[6]);
                        x41 = Double.parseDouble(territoryCoords[7]);
                        y41 = Double.parseDouble(territoryCoords[8]);
                    }

                    // дом
                    if (Objects.equals(territoryCoords[0], "4")) {
                        Count++;
                        if (inArea(x11, y11, x21, y21, x31, y31, x41, y41, x1, y1) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x2, y2) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x3, y3) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x4, y4)) {
                            // square of territory
                            area_home = Area(x1, y1, x2, y2, x3, y3, x4, y4);

                        }
                    }

                    // баня
                    if (Objects.equals(territoryCoords[0], "5")) {
                        Count++;
                        if (inArea(x11, y11, x21, y21, x31, y31, x41, y41, x1, y1) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x2, y2) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x3, y3) &
                                inArea(x11, y11, x21, y21, x31, y31, x41, y41, x4, y4)) {
                            // square of territory
                            area_Parilka = Area(x1, y1, x2, y2, x3, y3, x4, y4);

                        }
                    }

                    // не требующие площадь
                    if (Objects.equals(territoryCoords[0], "2") || Objects.equals(territoryCoords[0], "3") ||
                            Objects.equals(territoryCoords[0], "6") || Objects.equals(territoryCoords[0], "7")) {
                        Count++;
                    }
                }

                // записываем результат в файл ответа
                resultWriter.write("\t" + numb + "\t\t" + area + "\t\t\t" + Count + "\t\t\t" + area_home + "\t\t\s"
                        + area_Parilka + "\n");
                numb++;
            }

            // закрываем все файлы
            territoryReader.close();
            resultWriter.flush();
            resultWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для проверки, попадает ли точка внутрь произвольного четырехугольника
    public static boolean inArea(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4,
            double x11, double y11) {
        if (((x11 >= x1) & (x11 <= x3) & (y11 >= y1) & (y11 <= y3))
                || ((x11 >= x2) & (x11 <= x4) & (y11 >= y2) & (y11 <= y4))) {
            return true;
        }
        return false;
    }

    // метод для вычисления площади произвольного четырехугольника
    public static double Area(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return Math.abs((x2 - x1) * (y2 + y1) + (x3 - x2) * (y3 + y2) +
                (x4 - x3) * (y4 + y3) + (x1 - x4) * (y1 + y4)) / 2.0;
    }
}
