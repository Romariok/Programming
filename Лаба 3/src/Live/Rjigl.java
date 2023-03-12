package Live;
import Others.State;



public class Rjigl extends Policeman{
    public Rjigl(String name, Mood mood, State state, String nativeLanguage) {
        super(name, mood, state, nativeLanguage);
    }

    public void getCall(String themeOfCall){
        if (themeOfCall == "SPRUTS"){
            listen();
            setState(State.TALK);
            System.out.println(getName() + ": Дайте всю информацию об этом объекте");
        }
        else{
            System.out.println(getName() + ": Ничего не произошло!");
        }
    }
}
