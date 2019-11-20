package game;

import java.util.Random;

public class ComputerDrawResult {
    Computer computer = new Computer();
    Random random = new Random();

    public Score draw() {
        return computer.computerTemporarResult.get(random.nextInt(computer.computerTemporarResult.size()));
    }

}
