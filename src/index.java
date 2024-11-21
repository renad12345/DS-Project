
public class index{
    LinkedList<Document>all_doc;
    
    public index(){
     all_doc=new LinkedList<Document>();
     }
     
     public void addDocument(Document d){
      all_doc.insert(d);
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
          //System.out.println("all words in this doc are:");
          doc.words.display();
          all_doc.findNext();
          }
            Document doc = all_doc.retrieve();
          System.out.println("\n--------------------------");
          System.out.println("ID:" +doc.id);
          //System.out.println("all words in this doc are:");
          doc.words.display();
         }

         public LinkedList<Integer> booList(String bool){
            String query = bool.toLowerCase();
            Stack<LinkedList<Integer>> words = new Stack<String>();
            Stack<String> operaters = new Stack();
    String word;
    int start = 0;
    for(int i =0; i<words.length()); i++){
        if(words.charAt(i) == ' ')
        word = words.substring(start, i);
        start = i + 1;
    
    
    
        //insert in queue or stack
        if(!(word.equals("and") || word.equals("or")))
        words.push(retrieve(word));
        else{ 
            
            if(word.equals("or"))
            while (!operaters.empty())
           words.push(evalute(retrieve(words.pop()), retrieve(words.pop()), operaters.pop()));
    
            else
            while (!operaters.empty() && top.equals("and"))
            words.push(evalute(retrieve(words.pop()), retrieve(words.pop()), operaters.pop()));
    
           operaters.push(word);
        }
    }
    while (!operaters.empty())
    words.push(evalute(retrieve(words.pop()), retrieve(words.pop()), operaters.pop()));
    
    return words.pop();
        }
    //
        public static LinkedList<Integer> evalute(LinkedList<Integer> list1, LinkedList<Integer> list2, String op){
          LinkedList<Integer> result = list1;
          String word;
    
          if(op.equals("and"))
          if(!list1.empty()){
            list1.findFirst();
    
          while (!list1.last()) {
            if(list2.find(list1.retrieve()))
            result.insert(list1.retrieve());
            list2.findNext();
        
        }
    
            if(list2.find(list1.retrieve()))
            result.insert(list1.retrieve());
    
          
       
    
        }
    
    else{
        if(!list1.empty() || !list2.empty()){
    result = list1;
    list2.findFirst();
    
    while (!list2.last()){}
    if(!list1.find(list2.retrieve()))
    result.add(list2.retrieve());
    list2.findNext();}
    
    if(!list1.find(list2.retrieve()))
    result.add(list2.retrieve());
    
    
    }
    return result;
    }
    
    private LinkedList<Integer> retrieve (String word){
        LinkedList<Integer> ids = new LinkedList<>();
        for (Document doc : all_doc) {
            if (doc.contains(word)) {
                ids.insert(doc.getId());
            }
        }
        
        return ids;
    }


    
            
          
       public static void main(String[]args){
        index ind1 = new index();
        LinkedList<String>words= new LinkedList<>();
        words.insert("national");
        words.insert("flag");
        Document d1 = new Document(1,words);
        
        LinkedList<String> words2 = new LinkedList<>();
        words2.insert("green");
        words2.insert("color");
        
        Document d2 =new Document(2,words2);
        
        ind1.addDocument(d2);
        
        ind1.diplayDocuments();
   
        }
       }