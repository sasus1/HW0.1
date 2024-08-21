package org.example;
import java.util.HashMap;
package org.example;
public class Lesson13 {
    private static String analyzedData = " Регулярно регулировать конечно сложно, но очень нужно зебры в черно- белую полоску встречаются реже зебр в бело- черную полоску посчитать всех зЕбр в прайде может любой человек Это не такая уж и сложная задача.";
    private static final String format = "|%1$-40.38s|%2$-30.28s|\n";
    private static final HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        analyzedData = analyzedData.replaceAll("[^A-Za-zА-ЯЁа-яё0-9 ]", " ").toLowerCase();
        analyzedData = analyzedData.replaceAll("[\\s]{2,}", " ");
        String[] regularArray = analyzedData.split(" ");
        System.out.println("Текст имеет " + regularArray.length + " слов.");
        for (String s : regularArray) {
            hashMap.putIfAbsent(s, 0);
            hashMap.put(s, hashMap.get(s) + 1);
        }
        System.out.println(" Результат");
        System.out.println("_________________________________________________________________________");
        System.out.format(format, "         слово / фраза", " Количество повторений");
        System.out.println("=========================================================================");
        hashMap.entrySet().stream().sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()).forEach(stringIntegerEntry -> {
            String k = stringIntegerEntry.getKey();
            Integer v = stringIntegerEntry.getValue();
            System.out.format(format, " " + k + " ", "   " + +v + " раз.");
        });
        System.out.println("-------------------------------------------------------------------------");
    }
}
