import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static String staticString = "1";

    public static void main(String[] args) {
//        Consumer<String> consumer;
//        consumer = (s) -> System.out.println(s);
//        consumer.accept("Riz");
        String localString = "2";
        fooConsumer(s -> staticString = staticString.concat(s), "Riz");
        System.out.println(staticString);
    }

    public static void fooConsumer(Consumer<String> consumer, String str) {
        consumer.accept(str);
    }
}
