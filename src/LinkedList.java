public class LinkedList <T>{
   private Node<T> head;
 private Node<T> current;
 
  public LinkedList(){
   head=current=null;
   }

   public LinkedList(LinkedList L){
    L.current = head;
    while (L.current != null) {
        insert((T)L.current.data);
    }

    }

  public boolean empty(){
    return head==null;}
    
  public boolean last(){
     return current.next==null;}
     
   public boolean full(){
      return false;}
      
   public void findFirst(){
       current =head ;}
       
   public void findNext(){
        current=current.next;}
        
   public T retrieve(){
         return current.data;}
         
   public void update(T val){
          current.data =val;}
          
   public void insert(T val){
          Node<T> tmp;
          if(empty()){
           current=head=new Node<T>(val);}
           else{
            tmp=current.next;
            current.next= new Node<T>(val);
            current = current.next;
            current.next = tmp ;
            }
           }
          
   public void remove(){
           if(current == head){
            head=head.next;
            }
            else{
             Node<T> tmp = head ;
             while(tmp.next != current)
               tmp=tmp.next;
              tmp.next=current.next;
             }
             if(current.next == null)
              current=null;
             else
              current= current.next;
             }
   
   public void display(){
      if(head==null)
        System.out.println("Empty list");
        
       Node<T> tmp = head;
       
       while(tmp != null)
        {
         System.out.print(tmp.data +" ");
         tmp=tmp.next;
         }
        }

        public boolean exist(T x){
          Node<T> p =head;
          while (p!=null) {
            if (p.data.equals(x)) 
              return true;
            
              p=p.next;
          }
          return false;

        }

        public Node<T> getCurrent() {
            return current;
        }

        /*public Node<T> find(T data) {
            current = head;

            while (current!=null) {
                if(current.data.equals(data))
                return current;
            }
            return current;
        }*/

        public boolean find(T data) {
            current = head;

            while (current!=null) {
                if(current.data.equals(data))
                return true;
                current = current.next;
            }

            return false;
        }
}
