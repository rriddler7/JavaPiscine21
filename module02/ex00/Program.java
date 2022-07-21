package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Program {
    public static String content;
    private static final String SIGNATURES = "./module02/ex00/signatures.txt";

    public static String readSignatures(String filename)
    {
        content = "";
        try(FileInputStream input = new FileInputStream(filename)) {
            int buffer;
            while ((buffer = input.read()) != -1) {
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
        return magic;
    }

    public static String findSignature(String magic, HashMap<String, String> keyValue) {
        for (Map.Entry<String, String> item : keyValue.entrySet()) {
            if (magic.startsWith(item.getKey())) {
                return item.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue = parseSignatures(SIGNATURES);

        Scanner scan = new Scanner(System.in);
        String path;
        String value;
        try {
            FileOutputStream fileOutput = new FileOutputStream("result.txt", false);
            while (scan.hasNextLine()) {
                path = scan.nextLine();
                String magic = parsePath(path);
                if (path.equals("42")) {
                    System.exit(-1);
                }
                value = findSignature(magic, keyValue);
                if (value == null) {
                    System.out.println("UNDEFINED");
                }
                else {
                    System.out.println("PROCESSED");
                    for (int i = 0; i < value.length(); i++) {
                        fileOutput.write(value.charAt(i));
                    }
                    fileOutput.write('\n');
                }
            }
            fileOutput.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
