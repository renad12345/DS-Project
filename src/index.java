public class index {
    LinkedList<Document>all_doc;
 
 public index(){
  all_doc=new LinkedList<Document>();
  }
    
  
  public void addDocument(Document d){
   all_doc.insert(d);
   }

   public Document getDoc(int id){
    if (all_doc.empty()) {
      System.out.println("no document exist");
      return null;
      
    }
    all_doc.findFirst();
    while (!all_doc.last()) {
      if (all_doc.retrieve().id==id)
      return all_doc.retrieve();
      all_doc.findNext();
    }
    if (all_doc.retrieve().id==id)
      return all_doc.retrieve();

      return null;

   }
   
   public void diplayDocuments(){
    if(all_doc==null)
     {
     System.out.println("null docs");
     return;
     }
     else if(all_doc.empty()){
      System.out.println("empty docs");
      return;
      }
      
      all_doc.findFirst();
      while(!all_doc.last()){
       Document doc = all_doc.retrieve();
       System.out.println("\n--------------------------");
       System.out.println("ID:" +doc.id);
      
       doc.words.display();
       all_doc.findNext();
       }
         Document doc = all_doc.retrieve();
       System.out.println("\n--------------------------");
       System.out.println("ID:" +doc.id);
       
       doc.words.display();
      }
    
}
