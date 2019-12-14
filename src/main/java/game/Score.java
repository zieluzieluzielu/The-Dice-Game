package game;

public class Score {
    private String Score;

    Score(String score) {
        Score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return Score.equals(score.Score);
    }

    @Override
    public int hashCode() {
        return Score.hashCode();
    }

    @Override
    public String toString() {
        return Score;
    }


}
