package Objects;

import Others.State;

public class Spaceship extends Objects{
    private final int x_now;
    private final int x_SomeminAgo;
    private final int Minute;
    public Spaceship(String name, Materials material, State state, PlanetaryGravity planetaryGravity, int minute, int x_someminAgo, int x_now){
        super(name, material, state, planetaryGravity);
        this.x_now = x_now;
        this.x_SomeminAgo = x_someminAgo;
        this.Minute = minute;
    }
    @Override
    public void beAstroneersProperty(){
        System.out.println(getName()+" не является собственностью лунных астрономов");
    }
    public int[] getCoordinates(){
        int[] coordinates = {this.x_SomeminAgo, this.x_now, this.Minute};
        return coordinates;
    }

    @Override
    public String toString(){
        return "Это "+getName()+", сделан из "+getMaterial().toString();
    }
    @Override
    public int hashCode() {
        return this.getCoordinates().hashCode() + getMaterial().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        return this.toString() == obj.toString();
    }
}
