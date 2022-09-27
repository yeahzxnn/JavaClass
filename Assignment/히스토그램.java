import java.util.*;

public class Main{
    public static void main(String[] args){
        int[] num = new int[10];
        int[] hist = {0,0,0,0,0,0,0,0,0,0};

        Scanner in = new Scanner(System.in);
//숫자 10개 for문으로 입력 받고, 10단위 간격으로 출력하기 위해 if문
        System.out.println("숫자를 10개 입력하세요.");
        for(int i=0; i<num.length; i++){
            num[i] = in.nextInt();

            if(num[i]>=0 && num[i]<20){
                hist[0] ++;
            }
            else if(num[i]>=10 && num[i]<20){
                hist[1]++;
            }
            else if(num[i]>=20 && num[i]<30){
                hist[2]++;
            }
            else if(num[i]>=30 && num[i]<40){
                hist[3]++;
            }
            else if(num[i]>=40 && num[i]<50){
                hist[4]++;
            }
            else if(num[i]>=50 && num[i]<60){
                hist[5]++;
            }
            else if(num[i]>=60 && num[i]<70){
                hist[6]++;
            }
            else if(num[i]>=70 && num[i]<80){
                hist[7]++;
            }
            else if(num[i]>=80 && num[i]<90){
                hist[8]++;
            }
            else if(num[i]>=90 && num[i]<100){
                hist[9]++;
            }
        }
//배열에 카운팅을 해주고 값이 올라간만큼 ‘*’출력되게 for문 작성
        for(int i=0; i<hist.length; i++){
            System.out.println((i*10)+"~"+(i*10+9)+":");
            for(int j=0; j<hist[i]; j++){
                System.out.println("*");
            }
            System.out.println("");
        }
    }
}

