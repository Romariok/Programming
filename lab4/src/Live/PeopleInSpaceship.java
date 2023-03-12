package Live;

import Objects.Spaceship4;
import Others.State;

public class PeopleInSpaceship extends Human{
    private Spaceship4 Spaceship;
    public boolean AgreeOnLandingPlace = false;
    public PeopleInSpaceship(String names, Mood mood, State state, String language, Spaceship4 spaceship){
        super(names, mood, state, language);
        this.Spaceship = spaceship;
    }
    @Override
    public void gotIntelligence() {
        System.out.println(getName()+"имееет интеллект");
    }

    public void AgreeOnLandingPlace(){
        System.out.println(getName() + ": Мы не посадим " + this.Spaceship.getName()+" Пока не найдём корабль Незнайки и Пончика!");
        AgreeOnLandingPlace = true;
    }
}
