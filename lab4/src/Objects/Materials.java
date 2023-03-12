package Objects;

public enum Materials {
    METAL("metal"),
    PLASTIC("plastic"),
    SPACESTONE("spacestone"),
    GLASS("glass");


    private final String name;
    Materials(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
