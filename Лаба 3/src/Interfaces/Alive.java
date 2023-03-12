package Interfaces;

import Live.Mood;

public interface Alive {
    void dead();
    Mood getMood();
    void setMood(Mood newMood);
    void listen();

}
