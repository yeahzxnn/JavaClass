package Assignment;

class Student{
    String name;

    public Student(String name){
        this.name = name;
    }

    public String toString(){
        return "학생["+name+"]";
    }

}

public class StudentTest {
    public static void main(String[] args){
        System.out.println(new Student("김삿갓"));
        System.out.println(new Student("홍길동"));
    }
}
