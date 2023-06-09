package Live;

import Objects.*;
import Others.State;

public class Human extends LiveCreature {
    private final String nativeLanguage;
    private final String Name;
    private State state;
    public Human(String name, Mood mood, State state, String language){
        super(name, mood, state);
        this.Name = name;
        this.nativeLanguage = language;
    }

    public void speak(){
        setState(State.TALK);
        System.out.println(this.Name+" speaking "+this.nativeLanguage);
        setState(State.STAND);
    }
    public void setStateToSomething(Objects object, State newState){
        object.setState(newState);
    }
    public void gotIntelligence(){

    }



}
