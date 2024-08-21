package org.example;

public class Point {
    public static void main(String[] args) {
        String[][] correctMatrix = {
                {"4", "4", "4", "4"},
                {"9", "8", "9", "7"},
                {"5", "6", "5", "6"},
                {"1", "3", "1", "4"}
        };
        String[][] wrongSizeMatrix = {
                {"6", "8", "4", "7"},
                {"6", "1", "7", "3"},
                {"6","2"},
                {"0", "3", "7", "3"}
        };
        String[][] wrongChar = {
                {"2", "8", "7", "5"},
                {"3", "9", "7", "5"},
                {"7", "4", "7", "5"},
                {"", "6", "7", "5"}
        };

        try {
            System.out.println(Converter.strConverter(correctMatrix));
        } catch (CustomException e) {
            e.getMessage();
        }


        try {
            System.out.println(Converter.strConverter(wrongSizeMatrix));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Converter.strConverter(wrongChar));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
    }
}
