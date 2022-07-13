package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Program {
    public static String content;

    public static String readSignatures(String filename)
    {
        content = "";
        try(FileInputStream input = new FileInputStream(filename)) {
            int buffer;
            while ((buffer=input.read()) != -1) {
                content += (char)buffer;
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return (content);
    }

    public static HashMap parseSignatures(String filename) {
        String signature = readSignatures(filename);
        HashMap<String, String> keyValue = new HashMap<>();
        String [] tmp = signature.split("\n");
        for (int j = 0; j < tmp.length; j++) {
            String [] parse = tmp[j].split(", ");
            for(int i = 0; i < parse[1].length(); i++) {
                parse[1] = parse[1].replace(" ", "");
            }
            keyValue.put(parse[1], parse[0]);
        }
//        for(Map.Entry<String, String> item : keyValue.entrySet()){
//            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
//        }
        return keyValue;
    }

    public static String parsePath(String path) {
        String magic;

        int k;
        StringBuilder sbr = new StringBuilder();
        int m = 0;
        try (FileInputStream fileInput = new FileInputStream(path)) {
            while ((k = fileInput.read()) != -1 &&  m < 16) {
                m++;
                if (k < 16) {
                    sbr.append('0');
                }
                sbr.append(Integer.toHexString(k));
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        magic = sbr.toString().toUpperCase();
//        System.out.println("magic = " + magic);
        return magic;
    }

    public static String findSignature(String magic, HashMap<String, String> keyValue) {
        System.out.println(magic);
        for (Map.Entry<String, String> item : keyValue.entrySet()) {
            System.out.println("value " + item.getKey());
            if (magic.startsWith(item.getKey())) {
                return item.getValue();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue = parseSignatures("/Users/rriddler/Desktop/Java/module02/ex00/signatures.txt");

        Scanner scan = new Scanner(System.in);
        String path;
        String value;
        try (FileOutputStream fileOutput = new FileOutputStream("/Users/rriddler/Desktop/Java/module02/ex00/result.txt")) {
            while (scan.hasNextLine()) {
                path = scan.nextLine();
                String magic = parsePath(path);
                if (path.equals("42")) {
                    return;
//                    break;
                }
                value = findSignature(magic, keyValue);
                if (value == null) {
                    System.out.println("UNDEFINED");
                }
                else {
                    System.out.println("PROCESSED");
//                    System.out.println(value);
                    for (int i = 0; i < value.length(); i++) {
                        fileOutput.write(value.charAt(i));
                    }
                    fileOutput.write('\n');
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


//        System.out.println(magic);

//        for (String key: keyValue.keySet()) //keySet() возвращает множество ключей
//        {
//            String value = keyValue.get(key);
//            System.out.println(key + " --> " + value);
//        }
        }
}
