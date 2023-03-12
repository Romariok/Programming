package Objects;

import Live.Astronomers4;
import exceptions.inappropriateVelocity;
import Others.State;


public class GravityLocator extends Objects{
    public GravityLocator (String name, Materials material, State state, PlanetaryGravity planetaryGravity){
        super(name, material, state, planetaryGravity);
    }

    @Override
    public void beAstroneersProperty(){
        System.out.println(getName()+" является собственностью лунных астрономов");
    }
    public void checkVelocity(int[] a) throws inappropriateVelocity{
        if ((a[1] - a[0])/(a[2]*60) < 0 || (a[1] - a[0])/(a[2]*60)> 2400){
            throw new inappropriateVelocity();
        }
    }
    public int getVelocity(Meteorite mt){
        int[] a = mt.getCoordinates();
        checkVelocity(a);
        return (a[1] - a[0])/(a[2]*60);
    }
    public int getVelocity(Spaceship4 spc) {
        int[] a = spc.getCoordinates();
        checkVelocity(a);
        return (a[1] - a[0])/(a[2]*60);
    }
    public void getVolume(Spaceship4 spc, Astronomers4 ast){
        System.out.println(ast.getName()+": Volume of "+spc.getName()+ " is "+spc.getSize().toString());
    }
    public void getWeight(Spaceship4 spc, Astronomers4 ast){

        System.out.println(ast.getName()+": Weight of "+spc.getName()+" is "+Integer.toString(spc.getNumberOfPeople()*5+200));
    }

    @Override
    public String toString(){
        return "Этот "+getName()+" сделан из "+getMaterial().toString()+". Он нужен для вычисления скорость объекта, веса и объёма";
    }

    @Override
    public int  hashCode(){
        return this.getMaterial().hashCode() + this.getName().hashCode() + this.getState().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        return this.toString() == obj.toString();
    }
}
