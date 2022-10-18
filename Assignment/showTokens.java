import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenPrintTest {

    public static void main(String[] args) {

        String s = "of the people, by the people, for the people";
        try {
            showTokens(s, ", ");
        } catch (NoSuchElementException e) {
            System.out.println("끝");
        }
    }
    static void showTokens(String s, String s1){
        StringTokenizer st = new StringTokenizer(s, s1);
        while(true){
            System.out.println(st.nextToken());
        }
    }
}

//@realhsb...에게 무한감사....ㅠ
