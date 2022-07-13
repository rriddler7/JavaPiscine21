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
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {
  static Path currentPath;

  public static void cdCommand(String newDir) {
    Path newPath = currentPath.resolve(newDir).normalize();

    if (Files.exists(newPath) && Files.isDirectory(newPath) && Files.isReadable(newPath)) {
      currentPath = newPath;
      System.out.println(currentPath);
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
    List<Path> pathsToFilesInCurrentDirectory = Files.list(currentPath).collect(Collectors.toList());
    for (Path path : pathsToFilesInCurrentDirectory) {
      System.out.println(path.getFileName() + " " + (getSize(path) / 1024) + " KB");
    }
//    Files.list(Paths.get(URI.create(Program.path))).forEach(file -> {
//          System.out.println(file.getFileName() + " " + getSize(file));
//      });
  }

  public static void mvCommand(String pathFrom, String pathTo) throws IOException {
//    String pathFrom2 = "file://" + pathFrom;
//    String pathTo2 = "file://" + pathTo;
//    System.out.println(pathFrom2);
//    System.out.println(pathTo2);
//    Path currentPathFrom = Paths.get(URI.create(pathFrom2));
//    Path currentPathTo = Paths.get(URI.create(pathTo2));
//
////    File fileFrom = new File(pathFrom2);
////    File fileTo = new File(pathTo2);
//
//    File fileFrom = new File(pathFrom);
//    File fileTo = new File(pathTo);
//mv /Users/rriddler/Desktop/Java/module02/ex02/test/text.txt /Users/rriddler/Desktop/Java/module02/ex02/test2
    Path src;
    if (pathFrom.startsWith("/")) {
      src = Paths.get(pathFrom);
    } else {
      src = currentPath.resolve(pathFrom);
    }

    Path dest;
    if (pathTo.startsWith("/")) {
      dest = Paths.get(pathTo);
    } else {
      dest = currentPath.resolve(pathTo);
    }

    Path fileName = src.getFileName();
    Path destDir = dest.resolve(fileName);

    Files.move(src, destDir, REPLACE_EXISTING);

//    if (Files.exists(currentPathTo) && Files.isDirectory(currentPathTo) && Files.isReadable(currentPathTo)) {
//      System.out.println("move");
////      Files.move(currentPathFrom.toAbsolutePath(), currentPathTo.toAbsolutePath());
//      Files.move(fileFrom.toPath(), fileTo.toPath());
//    }
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
        if (command.startsWith("cd")) {
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
            String[] cmd;
            if (command.contains(" ")) {
              cmd = command.split(" ");
            }
            else {
              return;
            }
            mvCommand(cmd[1], cmd[2]);
          }
        }
      }
      else {
      System.out.println("Wrong path!");
      }
    }
}

//    String pathFrom = "file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/text.txt";
//    String pathTo = "file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/text.txt";
//    Files.move(Paths.get(URI.create(pathFrom)), Paths.get(URI.create(pathTo)));


//    String folder = ".";
//    String newFolder = path +"/" + folder;
//    Path newPath = Paths.get(URI.create(newFolder));
//    System.out.println(path);
//
//    if (Files.exists(newPath) && Files.isDirectory(newPath)) {
//      path = newPath.normalize().toString();
//      System.out.println(path);
//    }

//    System.out.println("size=" + getSize(Paths.get(URI.create("file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/3"))));
//    System.out.println(Files.size(Paths.get(URI.create("file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/3"))));

//    Iterator<Path> iterator = Paths.get(URI.create(path)).iterator();
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next().getFileName());
//    }
