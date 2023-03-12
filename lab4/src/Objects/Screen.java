package Objects;

import Others.State;

public class Screen extends Objects{
    public Screen (String name, Materials material, State state, PlanetaryGravity planetaryGravity){
        super(name, material, state, planetaryGravity);
    }
    @Override
    public void beAstroneersProperty(){
        System.out.println(getName()+" является собственностью лунных астрономов");
    }
    public SizeOfGravityWaves wavesIntoLine(Telescope4 tls, Spaceship4 spc){
        return tls.getWaves(spc);
    }
    public SizeOfGravityWaves wavesIntoLine(Telescope4 tls, Meteorite mt){
        return tls.getWaves(mt);
    }
    @Override
    public String toString(){
        return "Этот "+getName()+" сделан из "+getMaterial().toString()+". Он нужен для выведения кривой линии";
    }
    @Override
    public int hashCode(){
        return this.getMaterial().hashCode() + this.getName().hashCode() + this.getState().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        return this.toString() == obj.toString();
    }

}
