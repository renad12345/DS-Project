import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

          //Reading docs. + index
        LinkedList<Document> index= new LinkedList<Document>();

        String line = null;
        
        try {
         File f =new File(FileName);
         Scanner scan = new Scanner(f);
         
         scan.nextLine();
         while(scan.hasNextLine()){
          line = scan.nextLine();
          
          if(line.trim().length()<3){
           System.out.println("Empty line found,skipping this line="+line);
           break;
           }
           
           System.out.println(line);
           //String[] values = line.split(",");
           String x = line.substring(0,line.indexOf(','));
           int id = Integer.parseInt(x.trim());
           String content = line.substring(line.indexOf(',')+1).trim();
          }
          }catch(Exception e){
           System.out.println("end of file");
           }






        //inverted index
        LinkedList<Word> invertedIndex = new LinkedList<Word>(); 

        
         if(!index.empty()){
            index.findFirst();
        boolean found = false;
        while(!index.last()){
        if(index.find(word)){
            found = true;
            break;}
        index.findNext();}

        if(index.find(word))
            found = true;

        invertedIndex.insert(word);


        }

        //BST

        //menue

    
    }

    }

