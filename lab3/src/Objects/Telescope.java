package Objects;

import Others.State;

public class Telescope extends Objects{
    private final int multiplicity;
    public Telescope(String name, Materials material, State state, int Multiplicity){
        super(name, material, state);
        this.multiplicity = Multiplicity;
    }

    public final int getMultiplicity(){
        return this.multiplicity;
    }

    @Override
    public int hashCode() {
        return getMaterial().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return obj instanceof Telescope && this.hashCode() == obj.hashCode();
    }
}
