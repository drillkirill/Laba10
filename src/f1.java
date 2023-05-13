
import java.io.*;

public class f1 {
    public static void main(String[] args) throws IOException {

        File file= new File("C:\\Users\\Никита\\Desktop\\text_1.txt");
        BufferedReader fread = new BufferedReader(new FileReader(file));
        FileWriter fwrite = new FileWriter(file,true);
        char[] chars = fread.readLine().toCharArray();
        char searchChar = fread.readLine().charAt(0);

        String digit = fread.readLine();
        char[] digitChars = digit.toCharArray();

        // а) Определить количество цифр
        int digitsCount = 0;
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                digitsCount++;
            }
        }
        fwrite.write("\n\nКоличество цифр: " + digitsCount+"\n");

        // б) Выяснить, входит ли в последовательность символ, введенный с клавиатуры,
        //    если входит, то посчитать сколько раз.

        int searchCount = 0;
        for (char ch : chars) {
            if (ch == searchChar) {
                searchCount++;
            }
        }
        if (searchCount == 0) {
            fwrite.write("Символ не найден.\n");
        } else
            fwrite.write("Символ найден " + searchCount + " раз.\n");

        // в) Выяснить, верно ли, что среди символов имеются все цифры,
        // входящие в цифру, введенную с клавиатуры, например 70293.




        // Переводим введенную цифру в массив символов


        // Создаем массив для хранения флагов вхождения цифры в массив символов
        boolean[] digitExists = new boolean[10];

        // Проходим по массиву символов и устанавливаем флаги вхождения цифр
        for (char ch : digitChars) {
            if (Character.isDigit(ch)) {
                digitExists[ch - '0'] = true;
            }
        }

        // Проверяем, что все цифры входят в массив символов
        boolean isAllDigitsExists = true;
        for (int i = 0; i < digitExists.length; i++) {
            if (digitExists[i] == false) {
                isAllDigitsExists = false;
                break;
            }
        }
        // Выводим результат
        if (isAllDigitsExists) {
            fwrite.write("Массив содержит все цифры из введенного числа.\n");
        } else {
            fwrite.write("Массив не содержит все цифры из введенного числа.\n");
        }
        // г( Выяснить, имеется ли среди символов пара соседствующих скобок «(, ), {, }, [, ]»
        // если скобки присутствуют в последовательности,
        // то выяснить есть ли закрытые пары разного сочетания и вывести ответ.


        // Проверяем, есть ли скобки в последовательности
        boolean hasBrackets = false;
        for (int i = 0; i < digit.length(); i++) {
            char ch = digit.charAt(i);
            if (ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']') {
                hasBrackets = true;
                break;
            }
        }
        if (!hasBrackets) {
            fwrite.write("Последовательность не содержит скобок.\n");
        }

        // Проверяем, есть ли пара соседствующих скобок
        boolean hasPairedBrackets = false;
        int length = digit.length();
        for (int i = 0; i < length - 1; i++) {
            char ch = digit.charAt(i);
            char nextCh = digit.charAt(i + 1);
            if (ch == '(' && nextCh == ')' || ch == '{' && nextCh == '}' || ch == '[' && nextCh == ']') {
                hasPairedBrackets = true;
                break;
            }
        }

        if (!hasPairedBrackets) {
            fwrite.write("Последовательность не содержит пары соседствующих скобок.\n");
        }

        // Проверяем, есть ли закрытые пары разного сочетания
        boolean hasDifferentPairs = false;
        for (int i = 0; i < length - 1; i++) {
            char ch = digit.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char nextCh = digit.charAt(j);
                if ((ch == '(' && nextCh == ')') || (ch == '{' && nextCh == '}') ||
                        (ch == '[' && nextCh == ']')) {
                    hasDifferentPairs = true;
                    break;
                }
            }
            if (hasDifferentPairs) {
                break;
            }
        }

        // Выводим результат
        if (hasDifferentPairs) {
            fwrite.write("Последовательность содержит закрытые пары разного сочетания скобок.\n");
        } else {
            fwrite.write("Последовательность не содержит закрытых пар разного сочетания скобок.\n");
        }
        fwrite.close();
    }
}

