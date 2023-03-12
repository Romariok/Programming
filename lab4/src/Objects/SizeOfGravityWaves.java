package Objects;

public enum SizeOfGravityWaves {
    BIG("big"),
    MEDIUM("medium"),
    SMALL("small"),
    NOTENOUGH("not enough");

    private final String name;
    SizeOfGravityWaves(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
