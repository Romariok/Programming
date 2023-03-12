package Interfaces;

import Others.State;

public interface StateNameInterface {
    String getName();
    State getState();
    void setState(State newState);
}
