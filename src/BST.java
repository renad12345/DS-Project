
public class BST<K extends Comparable<K>,T>{

  class BSTNode<K extends Comparable<K>,T>{

    public K key;
    public T data;
    public BSTNode<K,T> left, right;

    public BSTNode(K k, T val){
    
        key= k;
        data= val;
        left= right= null;
    }

  
    public BSTNode(K k, T val, BSTNode<K,T> l, BSTNode<K,T> r){
    
        key= k;
        data= val;
        left= l;
        right= r;
  }
}


    BSTNode<K,T> root, current;
    int counter;
    
    public BST(){
        root= current= null;
        counter=0;
    }

    
    public boolean empty(){
        return root == null;
    
    }
    
    public boolean full(){
        return false;
    
    }
    
    public T retrieve(){
        T data =null;
          if (current != null)
               data = current.data;
          return data;

    
    }
    
    public int size(){
         return counter;
    }
    
     public void clear(){
          root = current = null;
          counter = 0;
    }
    
    public void update(T val){
            if (current != null)
                current.data = val;
    }




    
   
    public boolean findKey(K key){
    BSTNode<K,T> p= root,q = root;

    if(empty())
        return false;

    while(p!= null){
        q= p;
        if(p.key.compareTo(key)== 0){
            current= p;
            return true;
        }else if(key.compareTo(p.key)< 0){
            p= p.left;
        }else{
            p= p.right;
        }
    }

    current = q;
    return false;
}

    
    public boolean insert(K k, T val){
    if(empty()){
        root= current= new BSTNode<>(k, val);
        counter++;
        return true;
    }

    BSTNode<K, T> parentNode= null;
    BSTNode<K, T> currentNode= root;

    while(currentNode!= null){
        parentNode= currentNode;
        int comparison= currentNode.key.compareTo(k);

        if(comparison== 0){
            return false; 
        }else if(comparison> 0){
            currentNode= currentNode.left; 
        }else{
            currentNode= currentNode.right; 
        }
    }

    BSTNode<K, T> newNode= new BSTNode<>(k, val);

    if(k.compareTo(parentNode.key) < 0){
        parentNode.left = newNode;
    }else{
        parentNode.right = newNode;
    }

    current= newNode;
    counter++;
    return true;
}
 
public void add(String w, int id){

}

    public LinkedList<ScoredDocument> rankedSearch(String query){
    String[] termsInQuery= query.toLowerCase().split("\\s+");
    LinkedList<ScoredDocument> scoredDocs= new LinkedList<>();

    for(int i= 0;i< termsInQuery.length;i++){
        String term= termsInQuery[i];
        Word word= findInTree(root, term);
        if(word != null){
            processWordDocs(word, scoredDocs);
        }
  }

     return sortScoredDocuments(scoredDocs);
}

private Word findInTree(Node root, String term){
    if(root== null){
        return null;
    }
    if(term.equals(root.word.text)){
        return root.word;
    }
    
    else if(term.compareTo(root.word.text)< 0){
        return findInTree(root.left, term);
    } 
    
    else{
        return findInTree(root.right, term);
    }
}

private void processWordDocs(Word word, LinkedList<ScoredDocument> scoredDocs){
    word.doc_IDS.findFirst();
    while(!word.doc_IDS.last()){
        int docId= word.doc_IDS.retrieve();
        addScore(scoredDocs, docId, 1.0);
        word.doc_IDS.findNext();
    }
    addScore(scoredDocs, word.doc_IDS.retrieve(), 1.0);
}

private void addScore(LinkedList<ScoredDocument> scoredDocs, int docId, double score){
    scoredDocs.findFirst();
    while(!scoredDocs.last()){
        ScoredDocument doc = scoredDocs.retrieve();
        if(doc.getId()== docId){
            doc.addScore(score);
            return;
        }
        scoredDocs.findNext();
    }
    scoredDocs.insert(new ScoredDocument(docId, score));
}

private LinkedList<ScoredDocument> sortScoredDocuments(LinkedList<ScoredDocument> docs){
    LinkedList<ScoredDocument> sorted= new LinkedList<>();
    docs.findFirst();

    while(!docs.empty() && !docs.last()){
        ScoredDocument doc= docs.retrieve();
        sorted.findFirst();
        boolean inserted= false;

        while(!sorted.last()){
             if(sorted.retrieve().getScore()< doc.getScore()){
                sorted.insert(doc);
                inserted= true;
                break;
              }
            sorted.findNext();
         }

        if(!inserted){
          sorted.insert(doc);
        }

        docs.findNext();
    }

    sorted.insert(docs.retrieve());
    return sorted;
}

  





}
