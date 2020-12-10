package nl.novi.dpcc.observerpattern.domain;

public class Message {
    private final String activeClubName;
    private final String passiveClubName;
    private final MatchEventType matchEventType;

    public Message(String activeClubName, String passiveClubName, MatchEventType matchEventType) {
        this.activeClubName = activeClubName;
        this.passiveClubName = passiveClubName;
        this.matchEventType = matchEventType;
    }

    public String getActiveClubName() {
        return activeClubName;
    }

    public MatchEventType getMatchEventType() {
        return matchEventType;
    }

    public String getPassiveClubName() {
        return passiveClubName;
    }
}
