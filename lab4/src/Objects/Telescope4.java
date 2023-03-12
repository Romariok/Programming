package Objects;

import Others.State;

public class Telescope4 extends Telescope{
    private Angles Angles;
    public Telescope4(String name, Materials material, State state, PlanetaryGravity planetaryGravity, int multiplicity, Angles angles){
        super(name, material, state, planetaryGravity, multiplicity);
        this.Angles = angles;
    }

    public enum Angles{
        CENTER("center"),
        LEFT("left"),
        RIGHT("right"),
        UP("up"),
        DOWN("down");
        private final String name;
        Angles(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }
    public Angles getAngles(){
        return this.Angles;
    }
    public SizeOfGravityWaves getWaves(Meteorite mt){
        return mt.getSize();
    }
    public SizeOfGravityWaves getWaves(Spaceship4 spc){
        return spc.getSize();
    }

    @Override
    public String toString(){
        return "Этот "+getName()+" сделан из "+getMaterial().toString()+". Он нужен для наблюдения за объектами в космосе.\n"+
                "Он имеет кратность " + getMultiplicity() + "и направлен в " + getAngles().toString() + " сторону";
    }

    @Override
    public int hashCode(){
        return this.getMaterial().hashCode() + this.getName().hashCode() + this.getState().hashCode() +
                this.getAngles().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return obj instanceof Telescope4 && this.hashCode() == obj.hashCode();
    }
}
