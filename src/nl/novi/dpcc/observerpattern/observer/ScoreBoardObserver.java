package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;

public class ScoreBoardObserver implements Observer {
    private final String homeTeam;
    private final String guestTeam;

    private int homeTeamScore;
    private int guestTeamScore;

    private int homeTeamYellow;
    private int guestTeamYellow;
    private int homeTeamRed;
    private int guestTeamRed;

    public ScoreBoardObserver(String homeTeam, String guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

    @Override
    public void update(Message message) {
        String clubname = message.getActiveClubName();
        MatchEventType event = message.getMatchEventType();

        if (event == MatchEventType.GOAL) {
            goal(clubname);
        }
        if (event == MatchEventType.YELLOW_CARD) {
            yellowCard(clubname);
        }

        if (event == MatchEventType.RED_CARD) {
            redCard(clubname);
        }

        if (event == MatchEventType.END) {
            printScore();
        }
    }

    private void printScore() {
        System.out.println("End of Match");
        System.out.println("The score is:");
        System.out.println(homeTeam + " " + homeTeamScore + " : " + guestTeamScore + " " + guestTeam);
    }

    private void redCard(String clubname) {
        if (clubname.equalsIgnoreCase(homeTeam)){
            homeTeamRed++;
        }
        if (clubname.equalsIgnoreCase(guestTeam)){
            guestTeamRed++;
        }
        System.out.println(homeTeam + " now has " + homeTeamRed + " red cards and " + guestTeam + " has " + guestTeamRed + ".");
    }

    private void yellowCard(String clubname) {
        if (clubname.equalsIgnoreCase(homeTeam)){
            homeTeamYellow++;
        }
        if (clubname.equalsIgnoreCase(guestTeam)){
            guestTeamYellow++;
        }
        System.out.println(homeTeam + " now has " + homeTeamYellow + " yellow cards and " + guestTeam + " has " + guestTeamYellow + ".");
    }

    private void goal(String clubname) {
        if (clubname.equalsIgnoreCase(homeTeam))
            homeTeamScore++;
        if (clubname.equalsIgnoreCase(guestTeam))
            guestTeamScore++;
    }
}
