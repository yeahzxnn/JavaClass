//잘못된 코드이지만 나중에 보고 다시 수정하고 싶어 올려놓습니다!
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class LFU { // 알고리즘 클래스
    private int count; // 적재 카운트
    private int num;
    private int fPoint=1; // lfu에서 적재 카운트

    public LFU(LFU[] a, int num) {	// LFU 클래스 생성자
        this.count = 1;
        this.num = num;
    }

    public void countIncrease() { // 카운트 증가를 위한 메소드
        this.count++;
    }

    public void pointIncrease(){ // lfu 적재 카운트 증가를 위한 메소드
        this.fPoint++;
    }

    public void setFPoint(int fPoint){
        this.fPoint=fPoint;
    }

    public int getFPoint(){
        return fPoint;
    }

    public void setCount(int count) {	// count 변수의 값을 설정하는 setter
        this.count = count;
    }

    public int getCount() {	// count 변수를 가져오는 getter
        return count;
    }

    public int getNum() {	// num 변수를 가져오는 getter
        return num;
    }

}

public class LFUPrac {

    static ArrayList<Integer> list;    // "input.txt"에 있는 숫자를 입력받을 ArrayList
    static int cacheSize = 3;        // 캐시메모리 사이즈

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("/Users/syj/input(2).txt"));

        LFU[] lfu = new LFU[cacheSize];

        System.out.println("LFU 알고리즘");
        System.out.println("");

        list = new ArrayList<>();
        while (scan.hasNext()) {        // 99가 나올 떄까지 scanner에 있는 숫자를 ArrayList에 입력.
            int num = Integer.parseInt(scan.next());    // String -> Integer 형변환
            if (num == 99) break;
            list.add(num);
        }

        int[] input = new int[list.size()];        // 빠른 연산을 위해 ArrayList를 int[] 배열에 담음
        for (int i = 0; i < list.size(); i++) {
            input[i] = list.get(i);
        }

        double lfuHit = LFUTest(lfu, input);        // Hit 횟수를 세는 메서드


        System.out.print("LFU Hit ratio : ");
        System.out.printf("%.2f%%", (double) lfuHit / input.length * 100);        // 구한 hit 횟수를 통해 적중률을 구함

    }

    public static int LFUTest(LFU[] lfu, int[] input) { // LFU 알고리즘
        int hit = 0;
        int count = 0; // 배열에 null 값이 있는지를 확인하기 위한 변수
        int replacement = 0;

        for (int i = 0; i < input.length; i++) {

            System.out.println("No. Main Memory Block: " + input[i]);        // 주기억장치 라인 번호 출력
            if (input[i] == 99) break;

            for (int j = 0; j < lfu.length; j++) {

                if (lfu[j] == null) { // 값을 넣을 곳이 비어있을 경우
                    for (int k = 0; k < lfu.length; k++) {
                        if (lfu[k] != null)
                            lfu[k].countIncrease();

                    }
//                    increasePoint(lfu);
                    lfu[j] = new LFU(lfu, input[i]);
                    count++;
                    replacement++;
                    j = lfu.length;
                    break;

                } else if (lfu[j].getNum() == input[i]) { // 입력한 값이 이미 캐시메모리에 있을 경우 -> Hit!!
                    for (int k = 0; k < lfu.length; k++) {
                        if (lfu[k] != null)
                            lfu[k].countIncrease();            // 캐시메모리에 있는 라인번호의 우선순위 증가
                    }

                    System.out.println("==========적중입니다!!=========");
                    lfu[j].setCount(1); // 카운트를 다시 1로 만들어 줌
                    lfu[j].setFPoint(1); // 다시 포인트를 새것으로 만들어줌
                    lfu[j].countIncrease(); //사용 빈도 증가
                    hit++;
                    j = lfu.length;
                    break;

                } else if (count == lfu.length && same(lfu, input[i]) == 0) { // 캐시메모리가 꽉 차있고, 캐시메모리에 값이 없을 경우 -> 적중실패
                    for (int k = 0; k < lfu.length; k++) {
                        if (lfu[k] != null)
//                            increasePoint(lfu);
                            lfu[k].countIncrease();

                    }
                    System.out.println("=========실패입니다!!=========");
                    lfu[compare(lfu)] = new LFU(lfu, input[i]);
                    replacement++;
                    j = lfu.length;
                }
            }
            print(lfu);
            System.out.println("");

            System.out.println("");

        }
        System.out.println("========연산 완료입니다!!========");    // 연산 완료
        print(lfu);
        System.out.print(" Hit(적중율): " + hit + " ");

        return hit;
    }

    public static void print(LFU[] a) { // 캐시메모리에 있는 라인번호 출력 메서드
        System.out.print("캐시 메모리 : [ ");
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null)
                System.out.print(a[i].getNum() + " ");
            else
                System.out.print("x ");
        }
        System.out.print("]");
    }

    public static int same(LFU[] a, int num) { // 캐시메모리에 일치하는 라인 번호가 있는지 출력하는 메서드

        int sameCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null)
                continue;
            else if (a[i].getNum() == num)
                sameCount++;
        }
        return sameCount;
    }

    public static int compare(LFU[] a) { //LFU알고리즘에서 사용빈도가 낮은것 중에서 적재가 가장 오래된 곳을 찾아주는 메소드

        int compareNum = a[0].getCount();
        int compare = 0;
        int comparePoint = a[0].getFPoint();
        for (int i = 0; i < a.length; i++) {

            if (compareNum > a[i].getCount()) {
                compareNum = a[i].getCount();
                comparePoint = a[i].getFPoint();
                compare = i;

            } else if (compareNum == a[i].getCount() && comparePoint < a[i].getFPoint()) {

                comparePoint = a[i].getFPoint();
                compare = i;
            }
        }

        return compare;
    }
}
