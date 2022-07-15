package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.File;

public class Program {
    private static String filePath;
    private static String white;
    private static String black;


    public static void main(String[] args) {
        if (args.length != 3 && args[1].length() != 1 && args[2].length() != 1) {
            System.err.println("Wrong number of arguments!");
            System.exit(-1);
        }

        filePath = args[0];
        if (args[1].equals( ".")) {
            black = args[1];
        }
        if (args[2].equals("0")) {
            white = args[2];
        }
        else if (!(args[1].equals( ".")) || !(args[2].equals("0"))) {
            System.err.println("Wrong symbols of color arguments!");
            System.exit(-1);
        }

        File bmpFile = new File(filePath);
        if (!bmpFile.exists() || bmpFile.isDirectory()) {
            System.out.println("Wrong file!");
            System.exit(-1);
        }

        Logic.printIt(filePath, white, black);
    }
}
