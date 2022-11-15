import java.util.*;
import java.util.stream.*;

public class StreamEx {
    public static void main(String[] args) {
        String[] strings = {"갈매기","나비","다람쥐","라마"};
        Stream<String> ss = Stream.of(strings);

        ss.filter(x ->x.length()==2).forEach(x->System.out.println(x));
        }
    }
