package pr13.task6;

import java.io.*;
import java.util.*;

/**
 * Класс для построения цепочки слов, где последняя буква
 * текущего слова совпадает с первой буквой следующего слова
 */
public class StepByStep{  // Класс должен называться так же как файл

    private List<String> words = new ArrayList<>();

    /**
     * Чтение слов из файла
     */
    public void readWordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова по пробелам
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
            System.out.println("Прочитано " + words.size() + " слов из файла: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + filename);
        }
    }

    /**
     * Строит цепочку слов, где последняя буква текущего слова
     * совпадает с первой буквой следующего слова
     */
    public String getLine() {
        if (words.isEmpty()) {
            return "Нет слов для обработки";
        }

        // Используем список для хранения результата
        List<String> result = new ArrayList<>();
        // Создаем копию списка слов для работы
        List<String> remainingWords = new ArrayList<>(words);

        // Начинаем с первого слова в списке
        result.add(remainingWords.remove(0));

        // Флаг для отслеживания прогресса
        boolean wordAdded;

        do {
            wordAdded = false;

            // Ищем слово, которое можно добавить в конец цепочки
            for (int i = 0; i < remainingWords.size(); i++) {
                String currentWord = result.get(result.size() - 1);
                String nextCandidate = remainingWords.get(i);

                // Проверяем совпадение букв (без учета регистра)
                if (Character.toLowerCase(currentWord.charAt(currentWord.length() - 1)) ==
                        Character.toLowerCase(nextCandidate.charAt(0))) {

                    result.add(remainingWords.remove(i));
                    wordAdded = true;
                    break;
                }
            }

            // Если не нашли слово для конца, пробуем найти для начала
            if (!wordAdded && !remainingWords.isEmpty()) {
                for (int i = 0; i < remainingWords.size(); i++) {
                    String firstWord = result.get(0);
                    String prevCandidate = remainingWords.get(i);

                    // Проверяем, можно ли добавить слово в начало
                    if (Character.toLowerCase(prevCandidate.charAt(prevCandidate.length() - 1)) ==
                            Character.toLowerCase(firstWord.charAt(0))) {

                        result.add(0, remainingWords.remove(i));  // Добавляем в начало
                        wordAdded = true;
                        break;
                    }
                }
            }

        } while (wordAdded && !remainingWords.isEmpty());

        // Преобразуем результат в строку с использованием StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(" ");  // Добавляем пробел между словами
            }
        }

        // Если остались неиспользованные слова, добавляем их в конец
        if (!remainingWords.isEmpty()) {
            sb.append(" (осталось слов: ").append(remainingWords.size()).append(")");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // создаем объект того же класса, а не WordChainBuilder
        StepByStep builder = new StepByStep();
        Scanner scanner = new Scanner(System.in);

        // Чтение имени файла с консоли
        System.out.print("Введите имя файла со словами: ");
        String filename = scanner.nextLine().trim();

        // Чтение слов из файла
        builder.readWordsFromFile(filename);

        // Построение цепочки слов
        String result = builder.getLine();

        // Вывод результата
        System.out.println("\nРезультат построения цепочки:");
        System.out.println(result);

        scanner.close();
    }
}