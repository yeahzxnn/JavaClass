import java.util.Scanner;

public class Firstassignment{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("0-999 사이의 숫자를 입력하세요: ");
        //문자 입력을 String으로 받기
        String input = in.nextLine();
        //sum 변수 설정 및 초기화
        int sum=0;
        //for문을 자릿수 숫자만큼 돌리고 각 자릿수의 합을 sum에 더하기
        for(int i=0; i<input.length(); i++){
            sum+= Integer.parseInt(input.substring(i,i+1));
        }
        //값 출력하기
        System.out.println("각 자리 수의 합="+sum);
    }
}
