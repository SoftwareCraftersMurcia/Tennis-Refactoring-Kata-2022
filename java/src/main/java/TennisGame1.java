
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1 += 1;
        }
        else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2)
        {
            score = drawScoreCalculate(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = winOrAdvantage(m_score1, m_score2);
        }
        else
        {
            int tempScore=0;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
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
        }
        return score;
    }

    private String winOrAdvantage(int matchScore1, int matchScore2) {
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
