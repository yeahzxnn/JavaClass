import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Nation{
    private final String name; private final Type type;

    public Nation(String name, Type type){
        this.name = name; this.type =type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public boolean isIsland() { return getType() != Type.LAND; }

    public enum Type { LAND, ISLAND }
    public String toString() { return name; }

    public static final List<Nation> nations = List.of(
            new Nation("ROK", Type.LAND),
            new Nation("New Zealand", Type.ISLAND),
            new Nation("USA", Type.LAND),
            new Nation("China", Type.LAND),
            new Nation("Philiphine", Type.ISLAND),
            new Nation("United Kingdom", Type.ISLAND),
            new Nation("Sri Lanka", Type.ISLAND),
            new Nation("Morocco", Type.LAND)
    );

    public static void main(String[] args) {

        Stream<Nation> n1 = Nation.nations.stream();
        Stream<Nation> n2 = n1.filter(x -> x.getType() == Nation.Type.LAND);

        String land = n2.map(x -> x.getName()).collect(Collectors.joining(", "));

        System.out.println(land);
    }

}


