package homework3;

import java.util.HashMap;
import java.util.Map;

public class Words {
    public static String[] createWordsArr() {
        String[] wordsArr = {
                "Кирпичи",
                "Колбаса",
                "Колбаса",
                "Колбаса",
                "Кошка",
                "Кошка",
                "Лист",
                "Микстура",
                "Попытки",
                "Сервер",
                "Сосиски",
                "Суета",
                "Троллейбус",
                "Чай",
                "Экзистенциализм"
        };
        return wordsArr;
    }

    public static void doHashSet(String[] wordsArr) {
        Map<String, Integer> words = new HashMap<>();
        int count = 1;
        for (String s : wordsArr) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            } else words.put(s, count);
        }
        for (Map.Entry<String, Integer> entries : words.entrySet()) {
            if (entries.getValue() == 1) {
                System.out.println("Слово " + entries.getKey() + " встречается " + entries.getValue() + " раз.");
            } else System.out.println("Слово " + entries.getKey() + " встречается " + entries.getValue() + " раза.");
        }
    }
}
