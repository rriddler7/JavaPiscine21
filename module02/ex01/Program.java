package ex01;

import java.io.*;
import java.util.*;

public class Program {
    private static final String DICTIONARY_TXT = "dictionary.txt";

    public static List<String> readFile(String path) {
        List<String> words = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String buffer;
            while ((buffer = input.readLine()) != null ) {
                words.addAll(Arrays.asList(buffer.split(" +")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        words.remove("");
        return words;
    }

    public static Map<String, Integer> createEmptyVector(Set<String> dictionary) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : dictionary) {
            map.put(word, 0);
        }
        return map;
    }

    public static double numerator(Map<String, Integer> map1, Map<String, Integer> map2, Set<String> dictionary) {
        double num = 0;

        Iterator<String> iterator = dictionary.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            num += map1.get(item) * map2.get(item);
        }
        return num;
    }

    public static double denominator(Map<String, Integer> map) {
        double den = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            den += entry.getValue() * entry.getValue();
        }
        return Math.sqrt(den);
    }

    public static Map<String, Integer> getWordCount(Map<String, Integer> map, List<String> words) {
        for (String word : words) {
            map.put(word, map.get(word) + 1);
        }
        return map;
    }

    public static double getCosLength(Map<String, Integer> map1, Map<String, Integer> map2, Set<String> dictionary) {
        double num;
        double den;
        num = numerator(map1, map2, dictionary);;
        den = denominator(map1) * denominator(map2);
        return num/den;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments!");
            System.exit(-1);
        }

        List<String> file1 = readFile(args[0]);
        List<String> file2 = readFile(args[1]);
        Set<String> dictionary = new TreeSet<>();

        dictionary.addAll(file1);
        dictionary.addAll(file2);
        Map<String, Integer> map1 =  getWordCount(createEmptyVector(dictionary), file1);
        Map<String, Integer> map2 =  getWordCount(createEmptyVector(dictionary), file2);
        String similarity = "";
        similarity += getCosLength(map1, map2, dictionary);
        if (similarity.equals("NaN")) {
            similarity = "0.0";
        }
        System.out.printf("Similarity = %.4s", similarity);
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream(DICTIONARY_TXT, false);
            fileOutput.write(dictionary.toString().getBytes());
        } catch (FileNotFoundException e) {
            System.err.println("Can not open file!");
            System.exit(-1);
        }
        fileOutput.close();
    }
}
