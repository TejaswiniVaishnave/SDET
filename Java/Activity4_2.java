
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
public class Activity4_2 {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/session4/newfile.txt");
            boolean fStatus = file.createNewFile();
            if(fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            //get the file Object
            File fileUtil = FileUtils.getFile("src/session4/newfile.txt");
            //Read file
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
            //Create directory
            File destDir = new File("resources");
            //Copy file to directory
            FileUtils.copyFileToDirectory(file, destDir);
            //Get file from new directory
            File newFile = FileUtils.getFile(destDir, "newfile.txt");
            //Read data from file
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            //Print it
            System.out.println("Data in new file: " + newFileData);
        } catch(IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}
/*
 * In this activity we use FileUtils to perform file I/O operations. Create a
 * new text file using the default File Class. Use the createNewFile() method to
 * create a file. Write some text into the text file. Use the
 * FileUtils.getFile() method to get the file object. To read the file the
 * method is readFileToString().
 */
/*
 * Next, we create a new directory named resources. Copy the text file into this
 * directory using the copyFileToDirectory() method. To read data from this new
 * file using FileUtils class use the getFile() method to get the file. Then use
 * readFileToString() to read file
 */