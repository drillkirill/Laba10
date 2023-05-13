import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("C:\\Users\\User\\Desktop\\text_13.txt");
        File file2 = new File("C:\\Users\\User\\Desktop\\text_13.2.txt");
        File file3 = new File("C:\\Users\\User\\Desktop\\text_13.3.txt");

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             FileWriter writer = new FileWriter(file3)) {
            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                String[] mas_str = line1.split("\\s+");
                String[] stolb_res = line2.split("\\s+");
                int n = mas_str.length - 1;

                int[][] matrix = new int[n][n+1];
                int[] result = new int[n];

                for (int i = 0; i < n; i++) {
                    String[] rowStr = mas_str[i].split(",");
                    for (int j = 0; j < n+1; j++) {
                        matrix[i][j] = Integer.parseInt(rowStr[j]);
                    }
                }

                for (int i = 0; i < n; i++) {
                    result[i] = Integer.parseInt(stolb_res[i]);
                }

                int[] calculatedResult = vichislenie(matrix, result);

                if (isEqual(calculatedResult, stolb_res[n])) {
                    writer.write(line2 + "\n");
                }
                else {
                    String newLine = line1.replace(stolb_res[n], arrayToString(calculatedResult));
                    writer.write(newLine + "\n");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] vichislenie(int[][] mas, int[] result) {
        int n = mas.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mas[i][j] * result[j];
            }
            res[i] = sum;
        }

        return res;
    }

    public static boolean isEqual(int[] arr1, String str) {
        String[] arrStr = str.split(",");
        int n = arr1.length;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != Integer.parseInt(arrStr[i])) {
                return false;
            }
        }
        return true;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length-1)
                sb.append(",");
        }
        return sb.toString();
    }
}