package Objects;

public enum Direction {
    TOWARDSPLANET("towards the planet"),
    FROMPLANET("from the planet");

    private final String name;
    Direction(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
