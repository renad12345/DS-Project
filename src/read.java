import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class read {
    LinkedList<String> stopWords;
  index index1;
  invertedIndex inverted;
  BST invetredBST;
  int num_token=0;
  LinkedList<String> unique = new LinkedList<>();

  public read(){
    stopWords = new LinkedList<>();
    index1=new index();
    inverted= new invertedIndex();
    invetredBST= new BST();

  }

  public void readStopWords(String FileName){
    try{
      File file = new File(FileName);
      Scanner scan =new Scanner(file);
      while(scan.hasNextLine()){
        String line = scan.nextLine();
        stopWords.insert(line);

      }
    }catch(IOException ex){
      ex.printStackTrace();
    }
  }
 
 public void readAllDoc(String FileName){
  String line =null;

  try {
   File file =new File(FileName);
   Scanner scan = new Scanner(file);
   
   scan.nextLine();
   while(scan.hasNextLine()){
    line = scan.nextLine();

    if (line.trim().isEmpty() || !Character.isDigit(line.trim().charAt(0))) {
      System.out.println("Empty line found, skipping.");
      continue;
  }
    
    if(line.trim().length()<3){
     System.out.println("Empty line found,skipping this line="+line);
     continue;
     }



     String x = line.substring(0,line.indexOf(','));
     int id = Integer.parseInt(x.trim());
     String content = line.substring(line.indexOf(',')+1).trim();
     System.out.println("content="+content);

     LinkedList<String>WordsInDoc = MakeLinkedList(content,id);
     index1.addDocument(new Document(id, WordsInDoc));
    }
    }catch(Exception e){
       e.printStackTrace();
     System.out.println("end of file");
     }
     
    
     }

     public LinkedList<String> MakeLinkedList(String content,int id){
      LinkedList<String> WordsInDoc = new LinkedList<String>();
      makeIndex_And_InvertedIndex(content,WordsInDoc,id);
      return WordsInDoc;

     }

     public void makeIndex_And_InvertedIndex(String content ,LinkedList<String> WordsInDoc ,int id){
     // System.out.println("content2  "+content);

      content = content.replaceAll("\'"," " );

      content =content.replaceAll("-", " ");






     // content=content.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
     content=content.toLowerCase().replaceAll("[^a-zA-Z ]", "");

    
      String[] token =content.split("\\s");
     
   

     // String[] token =content.split(" ");

     // token.length= token.length+num_token;

      for(String w : token){
        //System.out.println("wordrrrr "+w);

        if(!unique.exist(w)){
         // System.out.println("**add unique1 " + w);

          unique.insert(w);
        }

       /*  if(!existInStopWords(w)  && !unique.exist(w) ){
          System.out.println("**add unique " + w);
          inverted.add(w);
        }*/


        

        if(!existInStopWords(w)){
         // System.out.println("not stop " + w);

          WordsInDoc.insert(w);
          inverted.add(w);
          inverted.index_addID(w,id);
          invetredBST.add(w,id);

        }
      }


     }

     public boolean existInStopWords(String word){
      if(stopWords==null || stopWords.empty())
       return false;
       stopWords.findFirst();
       while(!stopWords.last()){
        if(stopWords.retrieve().equals(word))
         return true;

         stopWords.findNext();
       }
       if(stopWords.retrieve().equals(word))
       return true;

       return false;
     }

     public void readAllFiles(String stopFile,String docFile){
      readStopWords(stopFile);
      readAllDoc(docFile);
     }
    
    
    }
