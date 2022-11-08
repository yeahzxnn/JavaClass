import java.util.ArrayList;

public class ArrayListEx{
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("갈매기");
        a.add("나비");
        a.add("다람쥐");
        a.add("라마");
        //방법1
        for(int i=0; i<4; i++){
            String n = a.get(i);
            if(n.length()==2){
                System.out.println(n);
            }
        }
      //방법2
      for(String animal: a){
            if(animal.length()==2){
                System.out.println(animal);
            }
        }
    }
}
