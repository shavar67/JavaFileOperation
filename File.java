package FilesIO;

import java.io.*;

public class File {


    public static void main(String[] args) throws IOException {
        readFile("/Users/shavar/MaterialApps/LeetCode/src/main/java/FilesIO/sample.txt");
        String data = "There are many variations of passages of Lorem Ipsum available \nbut the majority have suffered alteration in some form, by injected humour.";
        // writeFile(data);
        System.out.println();
        readFile("/Users/shavar/MaterialApps/LeetCode/src/main/java/FilesIO/lorem.txt");
    }

    public static void readFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        String lineToRead;
        System.out.println("Now reading from file: " + path);

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((lineToRead = bufferedReader.readLine()) != null) {
                System.out.printf("%s\n", lineToRead);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(path + " doesn't exist");
            System.out.println("File is empty.");
        } finally {
            bufferedReader.close();


        }

    }

    public static void writeFile(String data) throws IOException {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        java.io.File file = new java.io.File("Demo.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println();
                System.out.println(file.getAbsoluteFile() + " is now created");

            }
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            System.out.println();
            System.out.print("Finished Writing to file " + file.getAbsolutePath() + ".");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            bufferedWriter.close();
        }

    }
}
