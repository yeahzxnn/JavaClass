import java.util.*; 

class Dice{  //Dice 클래스를 만들고 메서드 roll()을 만든다.
    public int roll(){
        return (int)(Math.random()*10)%6+1; /
/Math.random()을 통해서 0.0~1.0 사이의 double형 수를 가져오고 10을 곱하고 
int 형으로 변환하면 소수 1번째 자리 정수로 얻을 수 있음
//1~6 사이의 숫자를 받아야하기 때문에 이 수에 6으로 나눈 나머지에 1을 더해준다
//6으로 나눈 나머지:0~5니까 여기에 1 더해서 1~6숫자가 나오니까 return 반환하기
    }
}

public class DiceTest {
    public static void main(String[] args){
        Dice d = new Dice();
        System.out.println("주사위의 숫자 : "+d.roll());
    }
}
