import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String calc(String input) {
        // Регулярное выражение для извлечения чисел и операции
        Pattern pattern = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            // заносим числа и операцию из строки в отдельные переменные
            int a = Integer.parseInt(matcher.group(1));
            String operation = matcher.group(2);
            int b = Integer.parseInt(matcher.group(3));

            // Проверка на диапазон чисел от 1 до 10
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно");
            }

            int result;

            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Некорректная операция");
            }

            return String.valueOf(result);
        } else {
            throw new IllegalArgumentException("Некорректный ввод. Ожидается формат: целое число операция целое число.");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите выражение с целыми числами, числа должны быть целыми в диапазоне от 1 до 10 включительно: ");
            String input = scanner.nextLine().trim();

            String output = calc(input);
            System.out.println("Результат: " + output);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}