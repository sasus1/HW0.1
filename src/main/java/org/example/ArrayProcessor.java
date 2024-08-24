package org.example;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив] должен содержать 4 строки.");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Каждая строка должна содержать 4 элемента.");
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка в ячейке [" + i + "][" + j + "]: " + array[i][j] + " не  число.");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "eight"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(validArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = processArray(invalidSizeArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = processArray(invalidDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
    }
}
