package infinite.main.task2;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final char[] separators;

    public Numbers(char[] separators) {
        this.separators = separators;
    }

    //Główna funkcja
    public double calculate(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            throw new Exception("Niepoprawne dane wejściowe!");
        }

        char operation = input.charAt(input.length() - 1);
        String numbersString;

        //Sprawdzenie czy dodano znak operacji
        if (operation != '+' && operation != '-') {
            System.out.println("Nie podano znaku operacji, stosuję działanie domyślne => DODAWANIE");
            operation = '+';
            numbersString = input;
        } else {
            numbersString = input.substring(0, input.length() - 1);
        }


        String[] stringNumbers = splitBySeparators(numbersString);
        List<Integer> numbers = new ArrayList<>();

        //Dodanie elementów typu String do listy jako typ Integer
        for (String stringNumber : stringNumbers) {
            try {
                numbers.add(Integer.parseInt(stringNumber));
            } catch (NumberFormatException e) {
                throw new Exception("Niepoprawna liczba: " + stringNumber);
            }
        }

        return performOperation(numbers, operation);
    }

    //Stworzenie regex dla podziału Stringa
    private String[] splitBySeparators(String input) {
        StringBuilder regex = new StringBuilder();
        for (char separator : separators) {
            regex.append("\\").append(separator);
        }
        return input.split("[" + regex + "]");
    }

    //Ostateczne wykonanie operacji
    private double performOperation(List<Integer> numbers, char operation) {
        int result = 0;
        if (operation == '+') {
            for (int number : numbers) {
                result += number;
            }
        } else if (operation == '-') {
            result = numbers.getFirst();
            for (int i = 1; i < numbers.size(); i++) {
                result -= numbers.get(i);
            }
        }
        return result;
    }
}
