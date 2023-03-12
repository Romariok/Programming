package Objects;

public enum PartsOfMoon {
    SHORE("the shore of the fossilized sea"),
    CRATOR("crator"),
    PEEK("peek of the mountain"),
    NOTINMOON("not in the moon");

    private final String name;
    PartsOfMoon(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
