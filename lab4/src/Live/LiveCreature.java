package Live;

import Others.State;
import Interfaces.Alive;
import Interfaces.StateNameInterface;

import java.util.concurrent.TimeUnit;


public abstract class LiveCreature implements Alive, StateNameInterface{
    private final String Name;
    private Mood Mood;
    private State State;
    public LiveCreature(String name, Mood mood, State state){
        this.Name = name;
        this.Mood = mood;
        this.State = state;
    }

    public final State getState(){
        return this.State;
    }
    public final Mood getMood(){
        return this.Mood;
    }
    public final String getName(){
        return this.Name;
    }

    public abstract void eat(String nameOfMeal);
    public abstract void listen();
    public void setState(State newState){
        if (this.getState() == newState){
            System.out.println(this.getName()+" is already "+ this.getState().toString());
        }
        else{
            this.State = newState;
            System.out.println(this.getName()+" is "+ this.getState().toString()+" right now");
        }
    }
    public final void setMood(Mood newMood){
        if (this.getMood() == newMood){
            System.out.println(this.getName()+" is already "+ this.getMood().toString());
        }
        else{
            this.Mood = newMood;
            System.out.println(this.getName()+" is "+ this.getMood().toString()+" right now");
        }
    }

    public void dead(){
        this.State = State.DEAD;
    }
}
