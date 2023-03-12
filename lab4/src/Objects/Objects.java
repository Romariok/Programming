package Objects;

import Others.State;
import Interfaces.NotAlive;
import Interfaces.StateNameInterface;

public abstract class Objects implements NotAlive, StateNameInterface {
    private final String Name;
    private final Materials Material;
    private State State;
    private PlanetaryGravity PlanetaryGravity;
    public Objects(String name, Materials material, State state, PlanetaryGravity planetaryGravity){
        this.Name = name;
        this.Material = material;
        this.State = state;
        this.PlanetaryGravity = planetaryGravity;
    }

    public abstract void beAstroneersProperty();
    public final State getState(){
        return this.State;
    }
    public final String getName(){
        return this.Name;
    }
    public final Materials getMaterial() {
        return this.Material;
    }
    public PlanetaryGravity getPlanetaryGravity(){
        return this.PlanetaryGravity;
    }
    public void setState(State newState){
        if (this.getState() == newState){
            System.out.println(this.getName()+" is already "+ this.getState().toString());
        }
        else{
            this.State = newState;
            System.out.println(this.getName()+" is "+ this.getState().toString()+" right now");
        }
    }
    public void setPlanetaryGravity(PlanetaryGravity newPlanetaryGravity){
        if (this.getPlanetaryGravity() == newPlanetaryGravity){
            System.out.println(this.getName()+" is already "+ this.getPlanetaryGravity().toString()+ " gravity");
        }
        else{
            this.PlanetaryGravity = newPlanetaryGravity;
            System.out.println(this.getName()+" is in "+ this.getPlanetaryGravity().toString()+" gravity right now");
        }
    }
}
