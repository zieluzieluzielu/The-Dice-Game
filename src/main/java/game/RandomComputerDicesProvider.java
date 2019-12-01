package game;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomComputerDicesProvider {

    private final Random random;

    public RandomComputerDicesProvider(Random random) {
        this.random = random;
    }

    public List<Integer> get(){
        return Stream.of(1,2,3,4,5)
                .map(e -> getSingle())
                .collect(Collectors.toList());
    }

    public Integer getSingle(){
        return new Integer(random.nextInt(6)+1);

    }
}
