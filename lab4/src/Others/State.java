package Others;

public enum State {
    STAND("standing"),
    DEAD("dead"),
    LISTEN("listening"),
    REPORT("reporting"),
    FLY("flying"),
    SEEK("seeking"),
    TALK("talking"),
    WALK("walking"),
    OBSERVE("observing"),
    SIT("sitting"),
    AREST("arrested"),
    USE("in use"),
    EAT("eating");
    private final String Status;
    State(String status) {
        Status = status;
    }
    @Override
    public final String toString() {
        return this.Status;
    }
}
