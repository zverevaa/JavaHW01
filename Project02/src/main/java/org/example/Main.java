package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Logger;


public class Main {
    public static <RootObject> void main(String[] args) throws IOException {
        String str = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
//        makeSQLRequest(str);
        int[] numbers = {3, 5, 4, 10, 5, 11, 6, 1};
        bubbleSort(numbers);

        /**
         *     Дана json строка (можно сохранить в файл и читать из файла) (Коллеги, если сложно будет распарсить .json -> можно работать как со строкой обычной)
         *
         * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
         *
         * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
         *
         * Пример вывода:
         *
         * Студент Иванов получил 5 по предмету Математика.
         *
         * Студент Петрова получил 4 по предмету Информатика.
         *
         * Студент Краснов получил 5 по предмету Физика.
         */

        ObjectMapper objectMapper = new ObjectMapper();
        File results = new File("src/main/resources/test.json");
        JsonParse jsonParse = objectMapper.readValue(results, JsonParse.class);

        System.out.println(jsonParse);
    }

    /**
     * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
     * <p>
     * Если значение null, то параметр не должен попадать в запрос.
     * <p>
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */

    public static void makeSQLRequest(String json) {
        StringBuilder newQuery = new StringBuilder("SELECT * FROM students WHERE");
        json = json.substring(1, json.length() - 1);
        System.out.println(json);
        String[] keyValue = json.split(", ");
        System.out.println(Arrays.toString(keyValue));

        for (int i = 0; i < keyValue.length; i++) {
            String[] pair = keyValue[i].split(":");
            String value = pair[1];
            System.out.println(value);
            if (!value.contains("null")) {
                String key = pair[0].substring(1, pair[0].length() - 1);

                System.out.println(key);
                if (i != 0) {
                    newQuery.append(" AND");
                }
                newQuery.append(" ").append(key).append(" = ").append(value);
            }
        }
        System.out.println(newQuery);
    }

    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     */

    public static void bubbleSort(int[] arr) {
        Logger logger = Logger.getLogger(Main.class.getName());
        try (PrintWriter out = new PrintWriter("log.txt")) {
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length - i; j++) {
                    if (arr[j - 1] > arr[j]) {
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
                out.println(Arrays.toString(arr));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}