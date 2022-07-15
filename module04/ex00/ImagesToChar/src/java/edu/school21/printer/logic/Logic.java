package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {
    public static void printIt(String filePath) {
        BufferedImage imageIt = null;

        try {
            imageIt = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.out.println("File can not read");
            System.exit(-1);
        }

        for (int y = 0; y < imageIt.getHeight(); y++) {
            for (int x = 0; x < imageIt.getWidth(); x++) {
                if (imageIt.getRGB(x, y) == -1) {
                    System.out.print(".");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
