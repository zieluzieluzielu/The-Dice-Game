package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Computer {
    Score aces = new Score("Aces");
    Score twos = new Score("Twos");
    Score threes = new Score("Threes");
    Score fours = new Score("Fours");
    Score fives = new Score("Fives");
    Score sixes = new Score("Sixes");
    Score threeOfaAKind = new Score("Three Of A Kind");
    Score fourOfaAKind = new Score("Four Of A Kind");
    Score fullHouse = new Score("Full House");
    Score smallStraight = new Score("Small Straight");
    Score largeStraight = new Score("Large Straight");
    Score fiveDice = new Score("5 dice");
    Score chance = new Score("Chance");
    Score bonusPoints = new Score("Bonus");

    public HashMap<Score, Boolean> computerPossibilities = new HashMap<>(); //(osobna klasa?)
    public HashMap<Score, Integer> computerResult = new HashMap<>(); //(osobna klasa?)
    public ArrayList<Score> computerTemporarResult = new ArrayList<>(); //(osobna klasa?)

    Random random;

    public Computer(Random random) {
        this.random = random;
    }

    public int randomDice() {
        return random.nextInt(6) + 1;
    }

    public int randomDiceAmount() {
        return random.nextInt(5) + 1;
    }

    public int countAces() {
        int value = randomDiceAmount();  //1-2-3-4-5
        return value;
    }

    public int countTwos() {
        int value = randomDiceAmount() * 2;  //2-4-6-8-10
        return value;
    }

    public int countThrees() {
        int value = randomDiceAmount() * 3;  //3-6-9-12-15
        return value;
    }

    public int countFours() {
        int value = randomDiceAmount() * 4;  //4-8-12-16-20
        return value;
    }

    public int countFives() {
        int value = randomDiceAmount() * 5;  //5-10-15-20-25
        return value;
    }

    public int countSixes() {
        int value = randomDiceAmount() * 6;  //6-12-18-24-30-36
        return value;
    }

    public int countThreeOfAKind() {
        int value = (randomDice() * 3) + (randomDice() * 2);
        return value;
    }

    public int countFourOfAKind() {
        int value = (randomDice() * 4) + randomDice();
        return value;
    }

    public int countFullHouse() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(25);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int countSmallStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(30);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int countLargeStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(40);
        options.add(0);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int count5Dice() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(50);
        options.add(0);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int countChance() {
        int value = randomDice() + randomDice() + randomDice() + randomDice() + randomDice();
        return value;
    }

    int topScore(HashMap<Score, Integer> result) {
        int countTopScore = ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)) + (result.get(bonusPoints)));
        return countTopScore;
    }


    int bottomScore(HashMap<Score, Integer> result) {
        int countBottomScore = ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
        return countBottomScore;
    }

    int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }


}
