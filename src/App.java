import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
          String fileName = "test.csv"; // Replace with your actual file name
        /*try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println("Read line: " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }*/
    
        System.out.println("Hello, World!");
        read read = new read();
       read.readAllFiles("stop.txt","test.csv");

      // read.inverted.printAllWordsWithDocIDs();
      LinkedList<Integer> result = read.inverted.booList("health AND sport");
      
      if(result != null)
      System.out.println("Here is result " + result.retrieve());


          //Reading docs. + index
       /*  LinkedList<Document> index= new LinkedList<Document>();

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

         BST<String, Word> invertedIndexBST = new BST<>();

        for (Document doc : index) {
            String[] words = doc.getContent().split("\\s+");

            for (String word : words) {
                if (invertedIndexBST.findKey(word)) {
                    Word existingWord = invertedIndexBST.retrieve();
                    existingWord.add_Id(doc.getId());
                } else {
                    Word newWord = new Word(word);
                    newWord.add_Id(doc.getId());
                    invertedIndexBST.insert(word, newWord);
                }
            }
        } 


        //menue*/

    
    }

    }

