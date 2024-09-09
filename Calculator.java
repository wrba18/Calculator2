import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите выражение (например: слово1 + слово2):");

        String input = scan.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        String firstString = parts[0];
        String action = parts[1];
        String secondString = parts[2];

        if (firstString == null ||
                !firstString.matches("[a-zA-Zа-яА-ЯёЁ!? ]+") ||
                firstString.length() > 40) {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        if (secondString == null ||
                !secondString.matches("[a-zA-Zа-яА-ЯёЁ!?0-9 ]+")) {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        if (action == null ||
                !action.matches("[/*+-]+")) {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        System.out.println("\"" + firstString + "\" " + action + " \"" + secondString + "\"");

        switch (action) {
            case "+" -> {
                String res = firstString + secondString;
                System.out.printf("\"%s\"%n", res);
            }
            case "-" -> {
                String res = firstString.replaceAll(secondString, "");
                System.out.printf("\"%s\"%n", res);
            }
            case "*" -> {
                int i;
                try {
                    i = Integer.parseInt(secondString);
                } catch (NumberFormatException e) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                if (i < 1) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                String res = firstString.repeat(i);
                System.out.printf("\"%s\"%n", res);
            }
            case "/" -> {
                int i;
                try {
                    i = Integer.parseInt(secondString);
                } catch (NumberFormatException e) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                if (i <= 0) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                if (firstString.length() < i) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                String res = firstString.substring(0, firstString.length() / i);
                System.out.printf("\"%s\"%n", res);
            }
            default -> System.out.println("...");
        }
    }
}
