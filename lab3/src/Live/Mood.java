package Live;

public enum Mood {
    HAPPY("happy"),
    SAD("sad"),
    ANGRY("angry"),
    PANIC("panic"),
    CALM("calm"),
    CONCENTRATED("concentrated");

    private final String Status;
    Mood(String status) {
        Status = status;
    }
    @Override
    public final String toString() {
        return this.Status;
    }
}
