
public class BST<K extends Comparable<K>,T>{

public class BSTNode<K extends Comparable<K>,T>{

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
 
  
  





}
