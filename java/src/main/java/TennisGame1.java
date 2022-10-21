
public class TennisGame1 implements TennisGame {
    
    private int pointsPlayer1;
    private int pointsPlayer2;

    public TennisGame1() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
    }

    @Deprecated
    public TennisGame1(String player1Name, String player2Name) {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            pointsPlayer1 += 1;
        }
        else {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {

        if (isDraw()) {
            return drawScoreCalculate(pointsPlayer1);
        }

        if (isGamePoint(pointsPlayer1) || isGamePoint(pointsPlayer2)) {
            return gamePointCalculate(pointsPlayer1, pointsPlayer2);
        }

        String score = "";
        int tempScore=0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = pointsPlayer1;
            else { score+="-"; tempScore = pointsPlayer2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private boolean isGamePoint(int pointsPlayer) {
        return pointsPlayer >= 4;
    }

    private boolean isDraw() {
        return pointsPlayer1 == pointsPlayer2;
    }

    private String gamePointCalculate(int matchScore1, int matchScore2) {
        int minusResult = matchScore1 - matchScore2;
        if (minusResult==1) {
            return "Advantage player1";
        } else if (minusResult ==-1) {
            return "Advantage player2";
        } else if (minusResult>=2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String drawScoreCalculate(int score) {
        switch (score) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";

            case 2:
                return "Thirty-All";

            default:
                return "Deuce";
        }
    }
}
