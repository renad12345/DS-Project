public class Document {
    LinkedList<String>words = new LinkedList<>();
 int id ;
 
 public Document(int id, LinkedList<String>words/* ,String content*/){
  this.id =id;
  this.words=words;
  }
  public boolean contains(String word) {
    return words.contains(word);
}
public int getId() {
    return id;
}

}
