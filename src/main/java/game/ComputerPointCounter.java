package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ComputerPointCounter {

    private Random random;

    public ComputerPointCounter(Random random) {
        this.random = random;
        scoreMap();
        scorePossibilities();
        scoreTemporarMap();
    }

    private HashMap<Score, Boolean> computerPossibilities = new HashMap<>();
    private HashMap<Score, Integer> computerResult = new HashMap<>();
    private ArrayList<Score> computerTemporarResult = new ArrayList<>();

    private void scoreMap() {
        computerResult.put(aces, 0);
        computerResult.put(twos, 0);
        computerResult.put(threes, 0);
        computerResult.put(fours, 0);
        computerResult.put(fives, 0);
        computerResult.put(sixes, 0);
        computerResult.put(threeOfaAKind, 0);
        computerResult.put(fourOfaAKind, 0);
        computerResult.put(fullHouse, 0);
        computerResult.put(smallStraight, 0);
        computerResult.put(largeStraight, 0);
        computerResult.put(fiveDice, 0);
        computerResult.put(chance, 0);
        computerResult.put(bonusPoints, 0);
    }


    private void scoreTemporarMap() {
        computerTemporarResult.add(aces);
        computerTemporarResult.add(twos);
        computerTemporarResult.add(threes);
        computerTemporarResult.add(fours);
        computerTemporarResult.add(fives);
        computerTemporarResult.add(sixes);
        computerTemporarResult.add(threeOfaAKind);
        computerTemporarResult.add(fourOfaAKind);
        computerTemporarResult.add(fullHouse);
        computerTemporarResult.add(smallStraight);
        computerTemporarResult.add(largeStraight);
        computerTemporarResult.add(fiveDice);
        computerTemporarResult.add(chance);
        computerTemporarResult.add(bonusPoints);
    }


    private void scorePossibilities() {
        computerPossibilities.put(aces, true);
        computerPossibilities.put(twos, true);
        computerPossibilities.put(threes, true);
        computerPossibilities.put(fours, true);
        computerPossibilities.put(fives, true);
        computerPossibilities.put(sixes, true);
        computerPossibilities.put(threeOfaAKind, true);
        computerPossibilities.put(fourOfaAKind, true);
        computerPossibilities.put(fullHouse, true);
        computerPossibilities.put(smallStraight, true);
        computerPossibilities.put(largeStraight, true);
        computerPossibilities.put(fiveDice, true);
        computerPossibilities.put(chance, true);
        computerPossibilities.put(bonusPoints, true);
    }

    public HashMap<Score, Integer> getComputerResult() {
        return computerResult;
    }

    private int roundNr = 1;

    private Score aces = new Score("Aces");
    private Score twos = new Score("Twos");
    private Score threes = new Score("Threes");
    private Score fours = new Score("Fours");
    private Score fives = new Score("Fives");
    private Score sixes = new Score("Sixes");

    private Score threeOfaAKind = new Score("Three Of A Kind");
    private Score fourOfaAKind = new Score("Four Of A Kind");
    private Score fullHouse = new Score("Full House");
    private Score smallStraight = new Score("Small Straight");
    private Score largeStraight = new Score("Large Straight");
    private Score fiveDice = new Score("5 dice");
    private Score chance = new Score("Chance");

    private Score bonusPoints = new Score("BonusPoints");
    private Score topScore = new Score("Top Score");
    private Score bottomScore = new Score("Bottom Score");

    public int getRoundNr() {
        return roundNr;
    }

    public int drawSize() {
        return random.nextInt(computerTemporarResult.size());
    }

    private Score draw() {
        return computerTemporarResult.get(drawSize());
    }

    public Score getAces() {
        return aces;
    }

    public Score getTwos() {
        return twos;
    }

    public Score getThrees() {
        return threes;
    }

    public Score getFours() {
        return fours;
    }

    public Score getFives() {
        return fives;
    }

    public Score getSixes() {
        return sixes;
    }

    public Score getThreeOfaAKind() {
        return threeOfaAKind;
    }

    public Score getFourOfaAKind() {
        return fourOfaAKind;
    }

    public Score getFullHouse() {
        return fullHouse;
    }

    public Score getSmallStraight() {
        return smallStraight;
    }

    public Score getLargeStraight() {
        return largeStraight;
    }

    public Score getFiveDice() {
        return fiveDice;
    }

    public Score getChance() {
        return chance;
    }

    public Score getBonusPoints() {
        return bonusPoints;
    }


    private int randomDice() {
        return random.nextInt(6) + 1;
    }

    private int randomDiceAmount() {
        return random.nextInt(5) + 1;
    }

    public int countAces() {
        return randomDiceAmount();
    }

    public int countTwos() {
        return randomDiceAmount() * 2;
    }

    public int countThrees() {
        return randomDiceAmount() * 3;
    }

    public int countFours() {
        return randomDiceAmount() * 4;
    }

    public int countFives() {
        return randomDiceAmount() * 5;
    }

    public int countSixes() {
        return randomDiceAmount() * 6;
    }

    public int countThreeOfAKind() {
        return (randomDice() * 3) + (randomDice() * 2);
    }

    public int countFourOfAKind() {
        return (randomDice() * 4) + randomDice();
    }

    public int countFullHouse() {
        List<Integer> options = new ArrayList<>();
        options.add(25);
        options.add(0);
        options.add(25);
        options.add(0);
        options.add(25);

        return options.get(random.nextInt(options.size()));
    }

    public int countSmallStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(30);
        options.add(0);
        options.add(30);
        options.add(30);
        return options.get(random.nextInt(options.size()));
    }

    public int countLargeStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(40);
        options.add(0);
        options.add(0);
        options.add(40);
        return options.get(random.nextInt(options.size()));
    }

    public int count5Dice() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(50);
        options.add(0);
        options.add(50);
        options.add(0);
        return options.get(random.nextInt(options.size()));
    }

    public int countChance() {
        return randomDice() + randomDice() + randomDice() + randomDice() + randomDice();
    }

    public int topScore(HashMap<Score, Integer> result) {
        return ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)));
    }


    public int bottomScore(HashMap<Score, Integer> result) {
        return ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
    }

    public int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
    }

    private void computerAces(Score score) {
        if (!computerPossibilities.get(score)) {
            computerTemporarResult.remove(score);
        }

    }

    public void computerPossibleTurn(User user) {
        if (!user.userTurn) {
            computerAces(aces);
            computerAces(twos);
            computerAces(threes);
            computerAces(fours);
            computerAces(fives);
            computerAces(sixes);
            computerAces(threeOfaAKind);
            computerAces(fourOfaAKind);
            computerAces(fullHouse);
            computerAces(smallStraight);
            computerAces(largeStraight);
            computerAces(fiveDice);
            computerAces(chance);
            computerAces(bonusPoints);
        }

    }

    public void computerTurn(User user) {
        if (!user.userTurn) {
            Score drawnResult = draw();

            if (drawnResult.equals(aces)) {
                computerResult.replace(aces, countAces());
                computerPossibilities.replace(aces, false);
            } else if (drawnResult.equals(twos)) {
                computerResult.replace(twos, countTwos());
                computerPossibilities.replace(drawnResult, false);
            } else if (drawnResult.equals(threes)) {
                computerResult.replace(threes, countThrees());
                computerPossibilities.replace(threes, false);
            } else if (drawnResult.equals(fours)) {
                computerResult.replace(fours, countFours());
                computerPossibilities.replace(fours, false);
            } else if (drawnResult.equals(fives)) {
                computerResult.replace(fives, countFives());
                computerPossibilities.replace(fives, false);
            } else if (drawnResult.equals(sixes)) {
                computerResult.replace(sixes, countSixes());
                computerPossibilities.replace(sixes, false);
            } else if (drawnResult.equals(threeOfaAKind)) {
                computerResult.replace(threeOfaAKind, countThreeOfAKind());
                computerPossibilities.replace(threeOfaAKind, false);
            } else if (drawnResult.equals(fourOfaAKind)) {
                computerResult.replace(fourOfaAKind, countFourOfAKind());
                computerPossibilities.replace(fourOfaAKind, false);
            } else if (drawnResult.equals(fullHouse)) {
                computerResult.replace(fullHouse, countFullHouse());
                computerPossibilities.replace(fullHouse, false);
            } else if (drawnResult.equals(smallStraight)) {
                computerResult.replace(smallStraight, countSmallStraight());
                computerPossibilities.replace(smallStraight, false);
            } else if (drawnResult.equals(largeStraight)) {
                computerResult.replace(largeStraight, countLargeStraight());
                computerPossibilities.replace(largeStraight, false);
            } else if (drawnResult.equals(fiveDice)) {
                computerResult.replace(fiveDice, count5Dice());
                computerPossibilities.replace(fiveDice, false);
            } else if (drawnResult.equals(chance)) {
                computerResult.replace(chance, countChance());
                computerPossibilities.replace(chance, false);
            }

            if (computerPossibilities.get(bonusPoints)) {
                if
                (((computerResult.get(aces)) + (computerResult.get(twos)) + (computerResult.get(threes)) + (computerResult.get(fours)) +
                        (computerResult.get(fives)) + (computerResult.get(sixes))) >= 63) {
                    computerResult.replace(bonusPoints, 35);
                    computerPossibilities.replace(bonusPoints, false);
                }
            }

            computerResult.replace(topScore, topScore(computerResult));
            computerResult.replace(bottomScore, bottomScore(computerResult));

            roundNr++;
        }

    }

}

