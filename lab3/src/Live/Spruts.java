package Live;

import Others.State;

public class Spruts extends Human {
    public Spruts(String name, Mood mood, State state, String nativeLanguage){
        super(name, mood, state, nativeLanguage);
    }

    public String getCall(String themeOfCall){
        if (themeOfCall == "MOON"){
            listen();
            setMood(Mood.ANGRY);
            setState(State.TALK);
            System.out.println(getName() +": Они хотят нам того самого сделать, АЛОО ПОЛИСМЕН СДЕЛАЙ ЧТО-НИБУДЬ!");
            return "SPRUTS";

        }
        else{
            System.out.println(getName()+ ": Ничего не произошла, а деньг, как и власти стало только больше!");
            return "Не надо звноить комиссару, на это нет причин";
        }
    }

}
