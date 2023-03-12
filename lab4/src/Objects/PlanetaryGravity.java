package Objects;

public enum PlanetaryGravity {
    NONE("none"),
    EARTH("earth"),
    MOON("moon");

    private final String name;
    PlanetaryGravity(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
