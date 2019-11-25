package game;

import java.util.List;

public interface ScoreInterface {

    public int count(List<Integer> dicesIntList, int whatToCount);
    public void acceptanceButton(User user); //to nie jest dobra metoda (acceptScore, byc w userze - przyjac score)


}
