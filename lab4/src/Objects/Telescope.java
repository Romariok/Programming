package Objects;

import Others.State;

public class Telescope extends Objects{
    private final int multiplicity;
    public Telescope(String name, Materials material, State state, PlanetaryGravity planetaryGravity, int Multiplicity){
        super(name, material, state, planetaryGravity);
        this.multiplicity = Multiplicity;
    }
    @Override
    public void beAstroneersProperty(){
        System.out.println(getName()+" является собственностью лунных астрономов");
    }
    public final int getMultiplicity(){
        return this.multiplicity;
    }

    @Override
    public String toString(){
        return "Этот "+getName()+" сделан из "+getMaterial().toString()+". Он нужен для наблюдения за объектами в космосе.\n"+
                "Он имеет кратность " + getMultiplicity() + ".";
    }

    @Override
    public int hashCode(){
        return this.getMaterial().hashCode() + this.getName().hashCode() + this.getState().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        return (this.toString() == obj.toString());
    }
}
