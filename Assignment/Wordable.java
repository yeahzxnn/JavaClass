interface Wordable{
        void word();
}

public class WordableTest {
    public static void main(String[] args) {
        Wordable[] m = {
                () -> System.out.println("가위"),
                () -> System.out.println("나비"),
                () -> System.out.println("다리"),
                () -> System.out.println("마차")
        };
        
        for(Wordable w : m){
            w.word();
        }
    }
}


