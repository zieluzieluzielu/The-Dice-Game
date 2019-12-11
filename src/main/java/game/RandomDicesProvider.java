package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomDicesProvider {

    private final Random random;

    public RandomDicesProvider(Random random) {
        this.random = random;
    }

    public List<Dice> get() {
        return Stream.of(1, 2, 3, 4, 5)
                .map(e -> getSingle())
                .collect(Collectors.toList());
    }

    public Dice getSingle() {
        return new Dice(random.nextInt(6) + 1, false);

    }
}
