package Objects;

import Interfaces.ThingInSpace;
import Others.State;

public class Meteorite extends Objects implements ThingInSpace {
    private SizeOfGravityWaves Size;
    public int x_now;
    public int x_SomeminAgo;
    public int Minute;
    public Direction Direction;
    private int AccelerationInSpace;
    public boolean rotationInSpace = false;
    public Meteorite(String name, Materials material, State state, SizeOfGravityWaves size, PlanetaryGravity planetaryGravity, Direction direction, int minute, int x_someminAgo, int x_now, int accelerationInSpace){
        super(name, material, state, planetaryGravity);
        this.Size = size;
        this.x_now = x_now;
        this.x_SomeminAgo = x_someminAgo;
        this.Minute = minute;
        this.Direction = direction;
        this.AccelerationInSpace = accelerationInSpace;
    }
    @Override
    public void beAstroneersProperty(){
        System.out.println(getName()+" не является собственностью лунных астрономов");
    }
    public int[] getCoordinates(){
        int[] coordinates = {this.x_SomeminAgo, this.x_now, this.Minute};
        return coordinates;
    }
    public int getAccelerationInSpace(){
        return this.AccelerationInSpace;
    }
    public Direction getDirection(){
        return this.Direction;
    }
    public final SizeOfGravityWaves getSize(){
        return this.Size;
    }
    public void setDirection(Direction newDirection){
        if (this.getDirection() == newDirection){
            System.out.println(this.getName()+" is already flying"+ this.getDirection().toString());
        }
        else{
            this.Direction = newDirection;
            System.out.println(this.getName()+" is flying"+ this.getDirection().toString()+" right now");
            this.rotationInSpace=true;
        }
    }
    public void setAccelerationInSpace(int newAcceleration){
        if (this.getAccelerationInSpace() == newAcceleration){
            System.out.println(this.getName()+" is already have"+ this.getAccelerationInSpace() + " acceleration");
        }
        else{
            this.AccelerationInSpace = newAcceleration;
            System.out.println(this.getName()+" is having"+ this.getAccelerationInSpace()+" acceleration right now");
        }
    }

    @Override
    public String toString(){
        return "Это "+getName()+", сделан из "+getMaterial().toString()+".\nОн летит с ускорением "+ getAccelerationInSpace()+
                " в "+ getDirection().toString()+" направлении. Он испускает волны тяготения размера " + getSize().toString();
    }

    @Override
    public int hashCode(){
        return this.getMaterial().hashCode() + this.getName().hashCode() + this.getState().hashCode() +
                this.getSize().hashCode() + this.getDirection().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        return this.toString() == obj.toString();
    }
}
