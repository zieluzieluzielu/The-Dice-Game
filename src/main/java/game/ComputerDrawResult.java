package game;

import java.util.Random;

public class ComputerDrawResult {

    Random random;
    Computer computer = new Computer(random);

    public Score draw() {
        return computer.computerTemporarResult.get(random.nextInt(computer.computerTemporarResult.size()));
    }

}
