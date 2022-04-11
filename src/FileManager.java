

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class FileManager {
    private String filename;
    private String directory;
    private List<String> fileData; // Returned fileio.data from the getFiles method

    // Get our path info?
    private Path directoryPath; // could we move this somewhere else possibly?
    private Path filePath;

    // Read a file!
    public FileManager(String filename, String directory) {
        this.filename = filename;
        this.directory = directory;

        // Paths for dir and files
        this.directoryPath = Paths.get(directory);
        this.filePath =  Paths.get(directory, filename);

        this.fileData = getFile();
    }

    // Create a function called getFile
    // Return the file fileio.data
    private List<String> getFile() {

        // Make sure the directory exists
        try {
            if(Files.notExists(directoryPath)) Files.createDirectories(directoryPath);
        } catch (IOException e) {
            System.out.println("Error creating directories " + directoryPath.getFileName());
            e.printStackTrace();
        }

        // Make sure the files exists
        try {
            if(Files.notExists(filePath)) Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("Error creating files " + filePath.getFileName());
            e.printStackTrace();
        }

        // If not create them (above)

        List<String> data = null;

        try {
            data = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Error reading files " + filePath.getFileName());
            e.printStackTrace();
        }

        // Error Handling? added try catch around each potential IOException


        // readAllLines -> returns a List<String>
        return data;
    }


    public boolean writeFile() {

        // Override the current fileio.data in the file, all of it

        // need the path
        // need the fileio.data
        try {
            Files.write(filePath ,fileData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + filename);
            return false;
        }

        return true;
    }

    public List<String> addLine(String string) {
        fileData.add(string);
        writeFile(); // as soon as the fileio.data is added, we write the file.
        return fileData;
    }

    // Way to print all the lines of the file so we can see its contents quickly
    public void printLines() {
        for (String line : fileData) {
            System.out.println(line);
        }
    }
//        Way to remove line and reprint
    public List<String> removeLine(String string) {

        fileData.removeIf(line -> line.toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT)));
        writeFile();
        return fileData;
    }
//   Locate specific line


    public List<String> getContact(String string) {
        for (String line : fileData) {
            if (line.toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT)))
                System.out.println(line);
        }
        return fileData;
    }
}
