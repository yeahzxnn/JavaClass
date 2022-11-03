import java.util.function.Consumer;

public class apple {
    public static void main(String[] args){
        Consumer<Integer> apple = x -> {
            if (x == 1) {
                System.out.println(x + " apple.");
            } else if (x > 1) {
                System.out.println(x + " apples.");
            }
        };
            apple.accept(3);
            apple.accept(1);
    }
}
