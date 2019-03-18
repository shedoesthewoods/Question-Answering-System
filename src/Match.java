package chatbot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Match {
    private String tourneyID;
    private String tourneyName;
    private char tourneyLevel;
    private Date tourneyDate;
    private String surface;
    private int matchNum;
    private int drawSize;
    private Player winner;
    private Player loser;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    
    public Match(String tourneyID, String tourneyName, String surface, int drawSize, char tourneyLevel, String tourneyDate,  int matchNum,
        Player winner, Player loser) {
        this.setTourneyID(tourneyID);
        this.setTourneyName(tourneyName);
        this.setSurface(surface);
        this.setDrawSize(drawSize);
        this.setTourneyLevel(tourneyLevel);
        this.setTourneyDate(tourneyDate);
        this.setMatchNum(matchNum);
        this.setWinner(winner);
        this.setLoser(loser);
    }

    public String getTourneyID() {
        return tourneyID;
    }

    public void setTourneyID(String tourneyID) {
        this.tourneyID = tourneyID;
    }

    public String getTourneyName() {
        return tourneyName;
    }

    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }

    public char getTourneyLevel() {
        return tourneyLevel;
    }

    public void setTourneyLevel(char tourneyLevel) {
        this.tourneyLevel = tourneyLevel;
    }

    public Date getTourneyDate() {
        return tourneyDate;
    }

    void setTourneyDate(String tourneyDate){
        try {
            this.tourneyDate = dateFormat.parse(tourneyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public int getDrawSize() {
        return drawSize;
    }

    public void setDrawSize(int drawSize) {
        this.drawSize = drawSize;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }
}
