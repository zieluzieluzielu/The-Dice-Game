package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ComputerPointCounter {

    Random random;

    public ComputerPointCounter(Random random) {
        this.random = random;
    }

    public void initialize() {
        scoreMap();
        scorePossibilities();
        scoreTemporarMap();
    }

    public HashMap<Score, Boolean> computerPossibilities = new HashMap<>();
    public HashMap<Score, Integer> computerResult = new HashMap<>();
    public ArrayList<Score> computerTemporarResult = new ArrayList<>();

    public HashMap<Score, Integer> scoreMap() {
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
        return computerResult;
    }


    public ArrayList<Score> scoreTemporarMap() {
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
        return computerTemporarResult;
    }


    public HashMap<Score, Boolean> scorePossibilities() {
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
        return computerPossibilities;
    }

    public HashMap<Score, Boolean> getComputerPossibilities() {
        return computerPossibilities;
    }

    public HashMap<Score, Integer> getComputerResult() {
        return computerResult;
    }

    public ArrayList<Score> getComputerTemporarResult() {
        return computerTemporarResult;
    }

    public int roundNr = 0;

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

    Score bonusPoints = new Score("BonusPoints");
    Score topScore = new Score("Top Score");
    Score bottomScore = new Score("Bottom Score");

    public int getRoundNr() {
        return roundNr;
    }

    public void scoreTable() {
        System.out.println("COMPUTER SCORE:");
        System.out.println("Aces: " + getComputerResult().get(getAces()));
        System.out.println("Twos: " + getComputerResult().get(getTwos()));
        System.out.println("Threes: " + getComputerResult().get(getThrees()));
        System.out.println("Fours: " + getComputerResult().get(getFours()));
        System.out.println("Fives: " + getComputerResult().get(getFives()));
        System.out.println("Sixes: " + getComputerResult().get(getSixes()));
        System.out.println("Top score: " + topScore(getComputerResult()));
        System.out.println("Bonus: " + getComputerResult().get(getBonusPoints()));
        System.out.println("");

        System.out.println("Three Of A Kind: " + getComputerResult().get(getThreeOfaAKind()));
        System.out.println("Four Of A Kind: " + getComputerResult().get(getFourOfaAKind()));
        System.out.println("Full House: " + getComputerResult().get(getFullHouse()));
        System.out.println("Small Straight: " + getComputerResult().get(getSmallStraight()));
        System.out.println("Large Straight: " + getComputerResult().get(getLargeStraight()));
        System.out.println("Chance: " + getComputerResult().get(getChance()));
        System.out.println("5 dice: " + getComputerResult().get(getFiveDice()));

        System.out.println("Bottom score: " + bottomScore(getComputerResult()));
        System.out.println("Total score: " + totalScore(getComputerResult()));
        System.out.println("\n");
    }

    public int drawSize() {
        return random.nextInt(computerTemporarResult.size());
    }

    public Score draw() {
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
        options.add(25);
        options.add(0);
        options.add(25);
        options.add(0);
        options.add(25);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int countSmallStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(30);
        options.add(0);
        options.add(30);
        options.add(30);
        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int countLargeStraight() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(40);
        options.add(0);
        options.add(0);
        options.add(40);

        int value = options.get(random.nextInt(options.size()));
        return value;
    }

    public int count5Dice() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        options.add(50);
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
        int countTopScore = ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)));
        return countTopScore;
    }


    int bottomScore(HashMap<Score, Integer> result) {
        int countBottomScore = ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
        return countBottomScore;
    }

    public int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }

    public void computerPossibleTurn(User user) {
        if (!user.userTurn) {

            if (!computerPossibilities.get(aces) && computerTemporarResult.contains(aces)) {
                computerTemporarResult.remove(aces);
            }
            if (!computerPossibilities.get(twos) && computerTemporarResult.contains(twos)) {
                computerTemporarResult.remove(twos);
            }
            if (!computerPossibilities.get(threes) && computerTemporarResult.contains(threes)) {
                computerTemporarResult.remove(threes);
            }
            if (!computerPossibilities.get(fours) && computerTemporarResult.contains(fours)) {
                computerTemporarResult.remove(fours);
            }
            if (!computerPossibilities.get(fives) && computerTemporarResult.contains(fives)) {
                computerTemporarResult.remove(fives);
            }
            if (!computerPossibilities.get(sixes) && computerTemporarResult.contains(sixes)) {
                computerTemporarResult.remove(sixes);
            }
            if (!computerPossibilities.get(threeOfaAKind) && computerTemporarResult.contains(threeOfaAKind)) {
                computerTemporarResult.remove(threeOfaAKind);
            }
            if (!computerPossibilities.get(fourOfaAKind) && computerTemporarResult.contains(fourOfaAKind)) {
                computerTemporarResult.remove(fourOfaAKind);
            }
            if (!computerPossibilities.get(fullHouse) && computerTemporarResult.contains(fullHouse)) {
                computerTemporarResult.remove(fullHouse);
            }
            if (!computerPossibilities.get(smallStraight) && computerTemporarResult.contains(smallStraight)) {
                computerTemporarResult.remove(smallStraight);
            }
            if (!computerPossibilities.get(largeStraight) && computerTemporarResult.contains(largeStraight)) {
                computerTemporarResult.remove(largeStraight);
            }
            if (!computerPossibilities.get(fiveDice) && computerTemporarResult.contains(fiveDice)) {
                computerTemporarResult.remove(fiveDice);
            }
            if (!computerPossibilities.get(chance) && computerTemporarResult.contains(chance)) {
                computerTemporarResult.remove(chance);
            }
            if (!computerPossibilities.get(bonusPoints) && computerTemporarResult.contains(bonusPoints)) {
                computerTemporarResult.remove(bonusPoints);
            }
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
                        (computerResult.get(fives)) + (computerResult.get(sixes))) >= 65) {
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

