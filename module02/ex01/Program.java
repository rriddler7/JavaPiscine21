package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        //прочитать файлы по словам
//    List<String> file1 = readFile("/Users/rriddler/Desktop/Java/module02/ex01/inputA.txt");
        List<String> file1 = Arrays.stream("aaa bba bba a ссс".split(" +")).collect(Collectors.toList());
//    List<String> file2 = readFile("/Users/rriddler/Desktop/Java/module02/ex01/inputB.txt");
        List<String> file2 = Arrays.stream("bba a a a bb xxx".split(" +")).collect(Collectors.toList());
        //создать общий словарь
        Set<String> dictionary = new TreeSet<>();
        dictionary.addAll(file1);
        dictionary.addAll(file2);
        //создать вектор файл
        Map<String, Integer> map1 =  getWordCount(createEmptyVector(dictionary), file1);
        Map<String, Integer> map2 =  getWordCount(createEmptyVector(dictionary), file2);
        //считаем близость векторов по формуле

        System.out.printf("Similarity = %.2f", getCosLength(map1, map2));
    }

    public static List<String> readFile(String path) {
        List<String> words = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String buffer;
            while ((buffer = input.readLine()) != null) {
                String [] buff = buffer.split(" +");
                System.out.println(buff);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return words;
    }

    public static Map<String, Integer> createEmptyVector(Set<String> dictionary) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : dictionary) {
            map.put(word, 0);
        }
        return map;
    }

    public static Map<String, Integer> getWordCount(Map<String, Integer> map, List<String> words) {
        for (String word : words) {
            map.put(word, map.get(word) + 1);
        }
        return map;
    }

    public static double getCosLength(Map<String, Integer> map1, Map<String, Integer> map2) {
        return 0.54456;
    }
}
