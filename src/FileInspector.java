import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                List<String> lines = Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()));
                int lineCount = lines.size();
                int wordCount = 0;
                int charCount = 0;

                for (String line : lines) {
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
    }
}
