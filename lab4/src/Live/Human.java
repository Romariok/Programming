package Live;

import Objects.*;
import Others.State;

import java.util.concurrent.TimeUnit;

public abstract class Human extends LiveCreature {
    private final String nativeLanguage;
    private final String Name;
    private State state;
    public Human(String name, Mood mood, State state, String language){
        super(name, mood, state);
        this.Name = name;
        this.nativeLanguage = language;
    }
    @Override
    public void listen(){
        setState(State.LISTEN);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    @Override
    public void eat(String nameOfMeal){
        setState(State.EAT);
        System.out.println(getName() + ": Сейчас я ем "+nameOfMeal);

    }
    public void speak(){
        setState(State.TALK);
        System.out.println(this.Name+" speaking "+this.nativeLanguage);
        setState(State.STAND);
    }
    public void setStateToSomething(Objects object, State newState){
        object.setState(newState);
    }
    public abstract void gotIntelligence();



}
