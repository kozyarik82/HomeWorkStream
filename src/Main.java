import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(Stream.empty(),Comparator.naturalOrder(),(min,max) ->
                System.out.println("min = " + min + " max = " + max));

        evenNumbers();

    }

    public static void findMinMax(Stream<? extends Integer> stream,
                                  Comparator<? super Integer> comparator,
                                  BiConsumer<? super Integer, ? super Integer> minMaxConsumer) {
        List<Integer> integers = stream.map(Integer::valueOf).collect(Collectors.toList());
        Integer min = integers.stream().min(comparator).orElse(null);
        Integer max = integers.stream().max(comparator).orElse(null);
        if (min != null) {
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }


    private static void evenNumbers() {
        List<Integer> nums = new ArrayList<>(List.of(1,28,5,14,44,7,42,55,16));
        nums.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


    }
}