package game;

import java.util.Random;

public class ComputerPointCounter {

    ComputerDrawResult computerDrawResult = new ComputerDrawResult();

    public int roundNr = 1;
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

    Random random = new Random();


    public int tableResult(Score score, Computer computer) {

        if (!computer.computerPossibilities.get(score)) {
            return computer.computerResult.get(score);
        } else
            return 0;
    }

    public void computerPossibleTurn(Computer computer, User user) {
        if (!user.userTurn) {

            if (!computer.computerPossibilities.get(aces) && computer.computerTemporarResult.contains(aces)) {
                computer.computerTemporarResult.remove(aces);
            }
            if (!computer.computerPossibilities.get(twos) && computer.computerTemporarResult.contains(twos)) {
                computer.computerTemporarResult.remove(twos);
            }
            if (!computer.computerPossibilities.get(threes) && computer.computerTemporarResult.contains(threes)) {
                computer.computerTemporarResult.remove(threes);
            }
            if (!computer.computerPossibilities.get(fours) && computer.computerTemporarResult.contains(fours)) {
                computer.computerTemporarResult.remove(fours);
            }
            if (!computer.computerPossibilities.get(fives) && computer.computerTemporarResult.contains(fives)) {
                computer.computerTemporarResult.remove(fives);
            }
            if (!computer.computerPossibilities.get(sixes) && computer.computerTemporarResult.contains(sixes)) {
                computer.computerTemporarResult.remove(sixes);
            }
            if (!computer.computerPossibilities.get(threeOfaAKind) && computer.computerTemporarResult.contains(threeOfaAKind)) {
                computer.computerTemporarResult.remove(threeOfaAKind);
            }
            if (!computer.computerPossibilities.get(fourOfaAKind) && computer.computerTemporarResult.contains(fourOfaAKind)) {
                computer.computerTemporarResult.remove(fourOfaAKind);
            }
            if (!computer.computerPossibilities.get(fullHouse) && computer.computerTemporarResult.contains(fullHouse)) {
                computer.computerTemporarResult.remove(fullHouse);
            }
            if (!computer.computerPossibilities.get(smallStraight) && computer.computerTemporarResult.contains(smallStraight)) {
                computer.computerTemporarResult.remove(smallStraight);
            }
            if (!computer.computerPossibilities.get(largeStraight) && computer.computerTemporarResult.contains(largeStraight)) {
                computer.computerTemporarResult.remove(largeStraight);
            }
            if (!computer.computerPossibilities.get(fiveDice) && computer.computerTemporarResult.contains(fiveDice)) {
                computer.computerTemporarResult.remove(fiveDice);
            }
            if (!computer.computerPossibilities.get(chance) && computer.computerTemporarResult.contains(chance)) {
                computer.computerTemporarResult.remove(chance);
            }
        }

    }

    public void computerTurn(Computer computer, User user) {
        if (!user.userTurn) {
            Score drawnResult = computerDrawResult.draw();
            //Score drawnResult = computer.computerTemporarResult.get(random.nextInt(computer.computerTemporarResult.size()));

            if (drawnResult.equals(aces)) {
                computer.computerResult.replace(aces, computer.countAces());
                computer.computerPossibilities.replace(aces, false);
            } else if (drawnResult.equals(twos)) {
                computer.computerResult.replace(twos, computer.countTwos());
                computer.computerPossibilities.replace(drawnResult, false);
            } else if (drawnResult.equals(threes)) {
                computer.computerResult.replace(threes, computer.countThrees());
                computer.computerPossibilities.replace(threes, false);
            } else if (drawnResult.equals(fours)) {
                computer.computerResult.replace(fours, computer.countFours());
                computer.computerPossibilities.replace(fours, false);
            } else if (drawnResult.equals(fives)) {
                computer.computerResult.replace(fives, computer.countFives());
                computer.computerPossibilities.replace(fives, false);
            } else if (drawnResult.equals(sixes)) {
                computer.computerResult.replace(sixes, computer.countSixes());
                computer.computerPossibilities.replace(sixes, false);
            } else if (drawnResult.equals(threeOfaAKind)) {
                computer.computerResult.replace(threeOfaAKind, computer.countThreeOfAKind());
                computer.computerPossibilities.replace(threeOfaAKind, false);
            } else if (drawnResult.equals(fourOfaAKind)) {
                computer.computerResult.replace(fourOfaAKind, computer.countFourOfAKind());
                computer.computerPossibilities.replace(fourOfaAKind, false);
            } else if (drawnResult.equals(fullHouse)) {
                computer.computerResult.replace(fullHouse, computer.countFullHouse());
                computer.computerPossibilities.replace(fullHouse, false);
            } else if (drawnResult.equals(smallStraight)) {
                computer.computerResult.replace(smallStraight, computer.countSmallStraight());
                computer.computerPossibilities.replace(smallStraight, false);
            } else if (drawnResult.equals(largeStraight)) {
                computer.computerResult.replace(largeStraight, computer.countLargeStraight());
                computer.computerPossibilities.replace(largeStraight, false);
            } else if (drawnResult.equals(fiveDice)) {
                computer.computerResult.replace(fiveDice, computer.count5Dice());
                computer.computerPossibilities.replace(fiveDice, false);
            } else if (drawnResult.equals(chance)) {
                computer.computerResult.replace(chance, computer.countChance());
                computer.computerPossibilities.replace(chance, false);
            }

            if (computer.computerPossibilities.get(bonusPoints)) {
                if
                (((computer.computerResult.get(aces)) + (computer.computerResult.get(twos)) + (computer.computerResult.get(threes)) + (computer.computerResult.get(fours)) +
                        (computer.computerResult.get(fives)) + (computer.computerResult.get(sixes))) >= 65) {
                    computer.computerResult.replace(bonusPoints, 35);
                    computer.computerPossibilities.replace(bonusPoints, false);
                }
            }

            computer.computerResult.replace(topScore, computer.topScore(computer.computerResult));
            computer.computerResult.replace(bottomScore, computer.bottomScore(computer.computerResult));

            roundNr++;
        }

    }

    public int getBottomScore(Computer computer) {
        int bottomScore = computer.bottomScore(computer.computerResult);
        return bottomScore;
    }

    public int getTopScore(Computer computer) {
        int topScore = computer.topScore(computer.computerResult);
        return topScore;
    }

    public int getTotalScore(Computer computer) {
        int totalScore = computer.totalScore(computer.computerResult);
        return totalScore;
    }

}

