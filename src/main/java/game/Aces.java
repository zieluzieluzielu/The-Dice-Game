package game;

import java.util.Collections;
import java.util.List;

public class Aces implements ScoreInterface {
    PointCounter pointCounter = new PointCounter();
    @Override
    public int count(List<Integer> dicesIntList, int whatToCount) {
        if (dicesIntList.contains(whatToCount)) {
            int occurrences = Collections.frequency(dicesIntList, whatToCount);
            return occurrences * whatToCount;
        } else {
            return 0;
        }
    }

    @Override
    public void acceptanceButton(User user) {

        user.userResult.replace(user.aces, user.count(user.dicesIntList, 1));
        user.userPossibilities.replace(user.aces, false);
        user.userTurn = false;
        pointCounter.clearTheTemporaryPoints(user);

    }
}
