import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.logging.FileHandler;

public class FileChanger {

    /*
    your turn:
    Write a program, which monitors the status of a file.
    If the file is modified, print out some kind of message.
    The file is located in resources and named demo.txt

    To-do:
    1. Create a thread that monitors the file. -> filechanger.java
        1.1 The thread should run indefinitely. so use a while(true) loop. -> filechanger.java
    2. Use the File class to check the last modified time of the file. -> filechanger.java
    3. If the last modified time changes, print out a message. -> filechanger.java
     */

    public static void main(String[] args) {
        Thread monitorThread = new Thread(() -> {
            Path path = Path.of("src/main/resources/demo.txt");
            long lastModified = path.toFile().lastModified();
            System.out.println("Monitoring demo.txt for changes...");

            while (true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (path.toFile().lastModified() != lastModified){
                    System.out.println("File has changed. TIME: " + new java.util.Date(path.toFile().lastModified()));
                    lastModified = path.toFile().lastModified();
                }
            }
        });

        monitorThread.start();
    }
}
