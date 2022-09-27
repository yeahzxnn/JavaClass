import java.util.*;

public class SecondAssignment {
    public static void main(String[] args){
        int a,b,c;
//삼각형 성립조건: a+b>c
//삼각형 두 변의 길이의 합 > 가장 긴 변의 길이
        for(a=1; a<10; a++){
            for(b=1; b<10; b++){
                for(c=1;c<10;c++){
                    if((a*a+b*b==c*c) && (a+b+c<=20)){
                        System.out.printf("a = %d b = %d c = %d",a,b,c);
                        System.out.println();
                    }
                }
            }
        }
    }
}
