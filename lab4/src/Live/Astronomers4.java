package Live;


import Objects.*;
import Others.State;


public class Astronomers4 extends Astronomers{
    private boolean suspicions = false;
    public Astronomers4(String name, Mood mood, State state, String nativeLanguage){
        super(name, mood, state, nativeLanguage);
    }

    public boolean checkObj(Spaceship4 spc){
        return (spc.getState()==State.FLY);

    }
    public boolean checkObj(Meteorite mt){
        return (mt.getState()==State.FLY);

    }
    public boolean checkMultiplicityAndUsing(Telescope4 tls){
        return (tls.getState()==State.USE && tls.getMultiplicity() >=8);
    }

    public boolean isScreenOn(Screen scr){
        return(scr.getState()==State.USE);
    }

    public boolean isGravityLocatorOn(GravityLocator gl){
        return(gl.getState()==State.USE);
    }


    public String exploreObject(Spaceship4 spc, Telescope4 tls, Screen scr, GravityLocator gl){
        if (checkObj(spc) && checkMultiplicityAndUsing(tls) && isScreenOn(scr) && isGravityLocatorOn(gl)){
            int Velocity = gl.getVelocity(spc);
            if (scr.wavesIntoLine(tls, spc)== SizeOfGravityWaves.BIG && spc.getDirection()==Direction.FROMPLANET && Velocity >1600){
                setState(State.TALK);
                System.out.println(getName() + ": Это противоречит законам небесной механики, согласно которым скорость тела, движущегося вблизи планеты, могла увеличиваться только в том случае, если бы тело приближалось к планете");
                System.out.println(getName()+": В этой штуке полюбому есть двигатель!");
                suspicions = true;
                setMood(Mood.PANIC);
                setState(State.REPORT);
                return "MOON";
            }
            else
            {
                return "Something else";
            }
        }
        else{
            setState(State.TALK);
            System.out.println(getName()+": Мы не можем исследовать лунное небо, у нас недостаточно оборудования для этого!");
            setState(State.SIT);
            return "Nothing";
        }

    }
    public String exploreObject(Meteorite mt, Telescope4 tls, Screen scr, GravityLocator gl){
        int Velocity = gl.getVelocity(mt);
        if (checkObj(mt) && checkMultiplicityAndUsing(tls) && isScreenOn(scr) && isGravityLocatorOn(gl)){
            if (scr.wavesIntoLine(tls, mt)== SizeOfGravityWaves.BIG && mt.getDirection()==Direction.FROMPLANET && Velocity >1600){
                setState(State.TALK);
                System.out.println(getName() + ": Это противоречит законам небесной механики, согласно которым скорость тела, движущегося вблизи планеты, могла увеличиваться только в том случае, если бы тело приближалось к планете");
                System.out.println(getName()+": В этой штуке полюбому есть двигатель!");
                suspicions = true;
                setMood(Mood.PANIC);
                setState(State.REPORT);
                return "MOON";
            }
            else
            {
                setMood(Mood.CALM);
                setState(State.TALK);
                System.out.println(getName()+": Это обычный метеорит");
                setState(State.OBSERVE);
                setMood(Mood.CONCENTRATED);
                return "METEORITE";
            }
        }
        else
        {
            setState(State.TALK);
            System.out.println(getName()+": Мы не можем исследовать лунное небо, у нас недостаточно оборудования для этого!");
            setState(State.SIT);
            return "Nothing";
        }

    }

    public void awarness(Spaceship4 spc){
        if (suspicions && spc.rotationInSpace && spc.getAccelerationInSpace()<0){
            setState(State.TALK);
            System.out.println(getName()+": Всё сходится! Это точно ракета! Никаких сомнений, это она!");
            setState(State.OBSERVE);
        }
    }
    public void saidAboutNumberOfPeople(Spaceship4 spc){
        System.out.println(getName()+" : Number of people on the board is "+ spc.getNumberOfPeople());
    }
}
