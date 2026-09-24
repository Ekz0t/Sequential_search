import java.io.*;
import java.util.Scanner;

class Main {
    private static final String File_Path = "C:\\Users\\Саша\\IdeaProjects\\Poisk\\Посл поиск.txt";

    public static void main(String[] args) {
        File file = new File(File_Path);
        if (!file.exists()) {
            System.out.println("Файл не найден по пути: " + file.getAbsolutePath());
            return;
        }

        if (!file.isFile()) {
            System.out.println("Указанный путь не является файлом.");
            return;
        }
        int[] a = new int[1000];
        try (Scanner scanner = new Scanner(file)) {
            int count = scanner.nextInt();
            if (count < 1000) {
                System.out.println("В файле меньше 1000 элементов.");
                return;
            }
            for (int i = 0; i < 1000; i++) {
                a[i] = scanner.nextInt();
                if (a[i] < 0 || a[i] > 10000) {
                    System.out.println("Недопустимое значение: " + a[i]);
                    return;
                }
            }
            long max = -1;
            for (int i = 0; i < 1000; i++) {
                for (int j = i + 1; j < 1000; j++) {
                    long product = (long) a[i] * a[j];
                    if (product % 14 == 0 && product > max) {
                        max = product;
                    }
                }
            }
            System.out.println("Ответ: " + max);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при открытии файла.");
        }
    }
}