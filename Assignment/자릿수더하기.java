import java.util.Scanner;

public class Firstassignment {
    public Firstassignment() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("0-999 사이의 숫자를 입력하세요: ");
        String input = in.nextLine();
        int sum = 0;

        for(int i = 0; i < input.length(); ++i) {
            sum += Integer.parseInt(input.substring(i, i + 1));
        }

        System.out.println("각 자리 수의 합=" + sum);
    }
}
