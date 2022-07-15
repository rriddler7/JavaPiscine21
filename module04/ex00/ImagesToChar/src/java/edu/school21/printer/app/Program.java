package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.File;

public class Program {
    private static String filePath;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong arguments!");
            System.exit(-1);
        }

        filePath = args[0];

        File bmpFile = new File(filePath);
        if (!bmpFile.exists() || bmpFile.isDirectory()) {
            System.out.println("Wrong file!");
            System.exit(-1);
        }

        Logic.printIt(filePath);
    }
}
