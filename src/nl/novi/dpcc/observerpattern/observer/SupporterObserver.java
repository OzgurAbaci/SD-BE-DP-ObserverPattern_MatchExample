package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;

public class SupporterObserver implements Observer {

    private final String favouriteClub;

    public SupporterObserver(String favouriteClub) {
        this.favouriteClub = favouriteClub;
    }

    public void update(Message message) {
        String activeClubName = message.getActiveClubName();
        String passiveClubName = message.getPassiveClubName();
        MatchEventType eventType = message.getMatchEventType();

        StringBuilder sb = new StringBuilder("The ").append(favouriteClub).append("-crowd ");

        if (favouriteClub.equalsIgnoreCase(activeClubName)) {
            sb.append(crowdReactionOwnTeam(eventType));
        } else if (favouriteClub.equalsIgnoreCase(passiveClubName)) {
            sb.append(crowdReactionOpponent(eventType));
        } else {
            sb.append(crowdReactionNeutral(eventType));
        }
        System.out.println(sb.toString());
    }

    private String crowdReactionNeutral(MatchEventType eventType) {
        switch (eventType) {
            case GOAL:
                return "is indifferent.";
            case PENALTY:
                return "takes a handful of popcorn.";
            case YELLOW_CARD:
                return "smiles secretly.";
            case SCHWALBE:
                return "posts on social media about the schwalbe";
            case RED_CARD:
                return "is amused";
            case STREAKER:
                return "cheers for the streaker";
        }
        return "leaves the stadium.";
    }


    private String crowdReactionOwnTeam(MatchEventType eventType) {
        switch (eventType) {
            case GOAL:
                return "cheers.";
            case PENALTY:
                return "cheers the striker for the penalty.";
            case YELLOW_CARD:
                return "boos the referee.";
            case SCHWALBE:
                return "cheers for the schwalbe";
            case RED_CARD:
                return "whistles at the referee";
            case STREAKER:
                return "cheers for the streaker";
        }
        return "leaves the stadium.";
    }

    private String crowdReactionOpponent(MatchEventType eventType) {
        switch (eventType) {
            case GOAL:
                return "shows dismay.";
            case PENALTY:
                return "yells the goalkeeper's name for the penalty.";
            case YELLOW_CARD:
                return "laughs at the yellow player.";
            case SCHWALBE:
                return "yells SCHWALBE!";
            case RED_CARD:
                return "cheers in celebration of the red card.";
            case STREAKER:
                return "cheers for the streaker";
        }
        return "leaves the stadium.";
    }

}
