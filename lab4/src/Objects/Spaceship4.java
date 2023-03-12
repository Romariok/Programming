package Objects;

import Interfaces.ThingInSpace;
import Others.State;
import exceptions.NegativeNumberOfPeopleException;
public class Spaceship4 extends Spaceship implements ThingInSpace {
    private SizeOfGravityWaves Size;
    private Direction Direction;
    private int NumberOfPeople;
    private int AccelerationInSpace;
    private PartsOfMoon PartOfMoon;

    public boolean rotationInSpace = false;

    public Spaceship4(String name, Materials material, State state, int numberOfPeople,SizeOfGravityWaves size, PlanetaryGravity planetaryGravity, PartsOfMoon partOfMoon, Direction direction, int minute, int x_someminAgo, int x_now, int acceleration) throws NegativeNumberOfPeopleException{
        super(name, material, state, planetaryGravity,minute, x_someminAgo, x_now);
        this.Size = size;
        this.Direction = direction;
        this.PartOfMoon=partOfMoon;
        if (numberOfPeople <0){
            throw new NegativeNumberOfPeopleException("Корабль не полетит без людей!");
        }
        this.NumberOfPeople = numberOfPeople;
        this.AccelerationInSpace = acceleration;
    }

    public int getNumberOfPeople(){
        return this.NumberOfPeople;
    }
    public int getAccelerationInSpace(){
        return this.AccelerationInSpace;
    }
    public PartsOfMoon getPartOfMoon(){
        return this.PartOfMoon;
    }
    public void setPartOfMoon(PartsOfMoon newPartOfMoon){
        if (this.getPartOfMoon() == newPartOfMoon){
            System.out.println(this.getName()+" is already at "+ this.getPartOfMoon().toString());
        }
        else{
            this.PartOfMoon = newPartOfMoon;
            System.out.println(this.getName()+" is at "+ this.getPartOfMoon().toString()+" right now");
        }
    }
    public Direction getDirection(){
        return this.Direction;
    }
    public void setDirection(Direction newDirection){
        if (this.getDirection() == newDirection){
            System.out.println(this.getName()+" is already flying "+ this.getDirection().toString());
        }
        else{
            this.Direction = newDirection;
            System.out.println(this.getName()+" is flying "+ this.getDirection().toString()+" right now");
            this.rotationInSpace=true;
        }
    }
    public void setAccelerationInSpace(int newAcceleration){
        if (this.getAccelerationInSpace() == newAcceleration){
            System.out.println(this.getName()+" is already have "+ this.getAccelerationInSpace() + " acceleration");
        }
        else{
            this.AccelerationInSpace = newAcceleration;
            System.out.println(this.getName()+" is having "+ this.getAccelerationInSpace()+" acceleration right now");
        }
    }
    public void seekingWhileLooping(int numberOfLoops, Spaceship4 spc){
        System.out.println("Пока "+getName()+" искали "+ spc.getName()+" они сделали "+ numberOfLoops+" витков вокруг Луны!");
        setPartOfMoon(spc.getPartOfMoon());
        System.out.println(getName()+": Мы нашли "+spc.getName());

    }
    public final SizeOfGravityWaves getSize(){
        return this.Size;
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
