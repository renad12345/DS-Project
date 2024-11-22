import java.util.Stack;

public class invertedIndex {
    LinkedList<Word> terms;

   public invertedIndex(){
    
    terms = new LinkedList<Word>();
   }

    public void add(String word){
        boolean found = false;

        if(terms.empty()){
        terms.insert(new Word(word));
        return;}


    terms.findFirst();
        while(!terms.last()){

        if(terms.retrieve().text.equals(word))
            return;
        

            terms.findNext();}

        if(terms.retrieve().text.equals(word)){
            return;
           
            }
        

terms.insert(new Word(word));

    

    }

    public void index_addID(String word, int id){
       // System.out.println("in index_addID " + word + id);
        if(!terms.empty()){
    terms.findFirst();
while (!terms.last()) {
   if( terms.retrieve().text.equals(word)){
            terms.retrieve().add_Id(id);
            return;
        }
    terms.findNext();
    }
        if( terms.retrieve().text.equals(word))
        terms.retrieve().add_Id(id);}

    }

    public LinkedList<Integer> booList(String bool){
        System.out.println("inside booList method");
        System.out.println("Received query: " + bool);
    
        // Clean the query string
        String query = bool.toLowerCase();
        query = query.replaceAll("\'"," ");
        query = query.replaceAll("-", " ");
        query = query.replaceAll("[^a-zA-Z ]", "");
        
        System.out.println("Cleaned query: " + query);
    
        String[] token = query.split("\\s");
        System.out.println("Tokenized query: ");
        for (String word : token) {
            System.out.println("Token: " + word);
        }
    
        LinkedStack<LinkedList<Integer>> words = new LinkedStack<>();
        LinkedStack<String> operaters = new LinkedStack<>();
        
        // Process each word in the query
        for (String word : token) {
            System.out.println("Processing word: " + word);
            
            if (!(word.equals("and") || word.equals("or"))) {
                LinkedList<Integer> docIds = retrieve(word);
                System.out.println("Retrieved docIDs for '" + word + "': " + docIds);
                words.push(docIds);
            } else { 
                System.out.println("Operator found: " + word);
                
                while (!operaters.empty() && 
                       ((word.equals("and") && operaters.top().equals("and")) || 
                        (word.equals("or") && (operaters.top().equals("and") || operaters.top().equals("or"))))) {
                    LinkedList<Integer> list2 = words.pop();
                    LinkedList<Integer> list1 = words.pop();
                    words.push(evalute(list1, list2, operaters.pop()));
                }
                operaters.push(word);
            }
        }
        
        while (!operaters.empty()) {
            LinkedList<Integer> list2 = words.pop();
            LinkedList<Integer> list1 = words.pop();
            words.push(evalute(list1, list2, operaters.pop()));
        }
        
        return words.pop();
        
    }
    

    


    public static LinkedList<Integer> evalute(LinkedList<Integer> list1, LinkedList<Integer> list2, String op) {
        LinkedList<Integer> result = new LinkedList<>();
        System.out.println("Evaluating with operator: " + op);
        
        // If "and" operator
        if (op.equals("and")) {
            System.out.println("List1 before processing: " + list1);
            System.out.println("List2 before processing: " + list2);
    
            if (list1 == null || list2 == null)
                return result;
    
            if (list1.empty() || list2.empty())
                return result;
    
            list1.findFirst();
            while (!list1.last()) {
                if (list2.find(list1.retrieve())) {
                    result.insert(list1.retrieve());
                    System.out.println("Added " + list1.retrieve() + " to result");
                }
                list1.findNext();
            }
    
            if (list2.find(list1.retrieve())) {
                result.insert(list1.retrieve());
                System.out.println("Added " + list1.retrieve() + " to result");
            }
        } else {
            // "or" operator
            System.out.println("List1 before processing: " + list1);
            System.out.println("List2 before processing: " + list2);
    
            if (list1.empty()) return list2;
            if (list2.empty()) return list1;
    
            result = list1;
            list2.findFirst();
    
            while (!list2.last()) {
                if (!result.find(list2.retrieve())) {
                    result.insert(list2.retrieve());
                    System.out.println("Added " + list2.retrieve() + " to result");
                }
                list2.findNext();
            }
    
            if (!result.find(list2.retrieve())) {
                result.insert(list2.retrieve());
                System.out.println("Added " + list2.retrieve() + " to result");
            }
        }
    
        System.out.println("Final result after evaluation: " + result);
        return result;
    }
    



public LinkedList<Integer> retrieve(String s){
    LinkedList<Integer> l = new LinkedList<>();
    if(terms.empty())
    return l;
    
    terms.findFirst();
        
        while(!terms.last()){
        if(terms.retrieve().text.equals(s))
            return terms.retrieve().doc_IDS;

            terms.findNext();}

            if(terms.retrieve().text.equals(s))
            return terms.retrieve().doc_IDS;

       return l;
    
}

public void printAllWordsWithDocIDs() {
    if (terms.empty()) {
        System.out.println("No words in the inverted index.");
        return;
    }

    terms.findFirst();
    System.out.println("Words and their associated document IDs:");
    
    while (!terms.last()) {
        Word currentWord = terms.retrieve();
        System.out.print("Word: " + currentWord.text + ", Document IDs: ");

        LinkedList<Integer> docIDs = currentWord.doc_IDS;
        if (docIDs != null && !docIDs.empty()) {
            docIDs.findFirst();
            while (!docIDs.last()) {
                System.out.print(docIDs.retrieve() + " ");
                docIDs.findNext();
            }
            // Check the last document ID
            System.out.print(docIDs.retrieve());
        } else {
            System.out.print("No document IDs found.");
        }
        System.out.println(); // New line for the next word
        terms.findNext();
    }

    // Check the last element
    Word lastWord = terms.retrieve();
    System.out.print("Word: " + lastWord.text + ", Document IDs: ");
    LinkedList<Integer> lastDocIDs = lastWord.doc_IDS;
    
    if (lastDocIDs != null && !lastDocIDs.empty()) {
        lastDocIDs.findFirst();
        while (!lastDocIDs.last()) {
            System.out.print(lastDocIDs.retrieve() + " ");
            lastDocIDs.findNext();
        }
        System.out.print(lastDocIDs.retrieve());
    } else {
        System.out.print("No document IDs found.");
    }
    System.out.println(); // Final new line
}



}


