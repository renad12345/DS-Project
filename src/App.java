import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
          String fileName = "dataset.csv"; // Replace with your actual file name


          System.out.println("Hello, World!");
          read read = new read();
         read.readAllFiles("stop.txt","dataset.csv");
  
         //read.inverted.printAllWordsWithDocIDs();
        LinkedList<Integer> result = read.inverted.booList("weather OR warming");
      
      
        //menue*/
      }
    }

 

