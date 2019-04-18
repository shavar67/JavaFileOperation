package FilesIO;

import java.io.*;

public class File {


    public static void main(String[] args) throws IOException {
     
        String data = "There are many variations of passages of Lorem Ipsum available \nbut the majority have suffered alteration in some form, by injected humour.";
         writeFile(data);
        System.out.println();
        //pass the path of the file you want to read 
        readFile(path);
    }

    public static void readFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        String lineToRead;
        System.out.println("Now reading from file: " + path);

        try {
            //instantiated a new BufferedReader object
            //which takes a fileReader object with a parameter of type string
            //which will be used as the path of the file you want to read.
            bufferedReader = new BufferedReader(new FileReader(path));
            //while th contents of the file is not null
            //we will read eachline until its empty.
            while ((lineToRead = bufferedReader.readLine()) != null) {
                System.out.printf("%s\n", lineToRead);
                //here we are just printing the contents of the file out to the console.
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
               //first we want to check if the file already exist, 
                //if not we create a new file.
            if (!file.exists()) {
                file.createNewFile();
                System.out.println();
                //print a message to the console where the filePath is located and also
                //append a message stating that the file is created.
                System.out.println(file.getAbsoluteFile() + " is now created");

            }
            //pass the path of the file we want to write to the filewriter object
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
            //the bufferedReader then starts to write the content to the file.
            bufferedWriter.write(data);
            System.out.println();
            //lastly we just print a message to the console when the file is finished being written
            //along with the path of the file where its located.
            System.out.print("Finished Writing to file " + file.getAbsolutePath() + ".");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            bufferedWriter.close();
            
        }

    }
}
