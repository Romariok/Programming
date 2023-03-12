package Objects;

import Others.State;

public class Spaceship extends Objects{
    public int x_now;
    public int x_10minAgo;
    public int PassengerNumber;
    public Spaceship(String name, Materials material, State state, int pasnum, int x_10minAgo, int x_now){
        super(name, material, state);
        this.x_now = x_now;
        this.x_10minAgo = x_10minAgo;
        this.PassengerNumber = pasnum;
    }
    public Spaceship(String name, Materials material, State state, int pasnum){
        super(name, material, state);
        this.PassengerNumber = pasnum;
    }
    public final int getNumber(){
        return this.PassengerNumber;
    }
    public int[] getCoordinates(){
        int[] coordinates = {x_10minAgo, x_now};
        return coordinates;
    }

    @Override
    public int hashCode() {
        return this.getCoordinates().hashCode() + getMaterial().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return obj instanceof Spaceship && this.hashCode() == obj.hashCode();
    }
}
