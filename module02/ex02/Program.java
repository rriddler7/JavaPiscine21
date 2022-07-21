package ex02;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
  static Path currentPath;

  public static void cdCommand(String newDir) {
    Path newPath = currentPath.resolve(newDir).normalize();

    if (Files.exists(newPath) && Files.isDirectory(newPath) && Files.isReadable(newPath)) {
      currentPath = newPath;
      System.out.println(currentPath);
    }
    else {
      System.err.println("No such directory");
    }
  }

  public static long getSize(Path path) {
    long size = 0;

    try {
      if (Files.isDirectory(path) && Files.isReadable(path)) {
        List<Path> collect = Files.list(path).collect(Collectors.toList());
        for (Path p : collect) {
          size += getSize(p);
        }
      }
      return size + Files.size(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return size;
  }

  public static void lsCommand() throws IOException {
    File file = new File(String.valueOf(currentPath));
    if (!file.exists()) {
      return;
    }
    List<Path> pathsToFilesInCurrentDirectory = Files.list(currentPath).collect(Collectors.toList());
    for (Path path : pathsToFilesInCurrentDirectory) {
      System.out.println(path.getFileName() + " " + (long)Math.ceil((getSize(path) / 1024)) + " KB");
    }
  }

  public static void mvCommand(String pathFrom, String pathTo) {
    if (pathFrom.equals(pathTo)) {
      return;
    }
    Path wayFrom, wayTo;
    wayFrom = Paths.get(currentPath.toString() + '/' + pathFrom).normalize();
    wayTo = Paths.get(currentPath.toString() + '/' + pathTo).normalize();

    String wayStrFrom, wayStrTo;
    wayStrFrom = wayFrom.toString();
    wayStrTo = wayTo.toString();

    File fileFrom = new File(wayStrFrom);
    File fileTo = new File(wayTo.toString());
    if (!fileFrom.exists()) {
      System.err.println("where is no such file" + pathFrom);
      return;
    }
    if (fileTo.isDirectory()) {
      wayStrTo = wayStrTo + '/' + pathFrom;
    }
    Path result = null;
    try {
      result = Files.move(Paths.get(wayStrFrom), Paths.get(wayStrTo));
    } catch (IOException e) {
      System.out.println("Exception while moving file: " + e.getMessage());
    }
    if (result != null) {
      System.out.println("File moved successfully.");
    } else {
      System.out.println("File movement failed.");
    }
  }

  public static void main(String[] args) throws IOException, URISyntaxException {
    if (args.length != 1 && !args[0].startsWith("--current-folder=")) {
      System.out.println("Wrong arguments!");
      System.exit(-1);
    }
    String [] currPath = args[0].split("=");
    String path = "file://" + currPath[1];
    currentPath = Paths.get(URI.create(path));

    if (Files.exists(currentPath) && Files.isDirectory(currentPath) && Files.isReadable(currentPath)) {
      Scanner scan = new Scanner(System.in);
      String command;
      String newDir;
      while (scan.hasNextLine()) {
        command = scan.nextLine();
        if (command.startsWith("exit")) {
          System.exit(0);
        }
        else if (command.startsWith("cd")) {
          if (command.contains(" ")) {
            String[] cmd = command.split(" ");
            newDir = cmd[1];
          }
          else {
            newDir = "";
          }
          cdCommand(newDir);
          }
        else if (command.equals("ls")) {
            lsCommand();
          }
        else if (command.startsWith("mv")) {
            String[] mvCmd;
            if (command.contains(" ")) {
              mvCmd = command.split(" ");
            }
            else {
              return;
            }
            mvCommand(mvCmd[1], mvCmd[2]);
        }
        else {
          System.out.println("Insert commands: ls, cd or mv");
        }
      }
    }
    else {
      System.out.println("Wrong path!");
    }
  }
}
