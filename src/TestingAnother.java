import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestingAnother {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(5);

        Optional<Integer> reduce = list.stream().reduce((a, b) -> (a>b)?a:b);
        System.out.println(reduce.get());

    }
}
