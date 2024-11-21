import java.util.Stack;

public class invertedIndex extends LinkedList{
    LinkedList<Word> terms;

    public void add(String word, int id){
if(!terms.empty()){
    terms.findFirst();
        boolean found = false;
        while(terms.last()){
        if(terms.retrieve().text.equals(word)){

            break;}
            terms.findNext();}

        if(terms.retrieve().text.equals(word)){
            found = true;
            }

        terms.insert(new Word(word));

if(!found)
terms.insert(new Word(word));

    }

    }

    public void index_addID(String word, int id){
    terms.findFirst();;

        while (terms.retrieve().text.equals(word)) {
            terms.retrieve().add_Id(id);
        }
       
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


}
