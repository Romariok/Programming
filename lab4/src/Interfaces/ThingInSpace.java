package Interfaces;

import Objects.Direction;
import Objects.SizeOfGravityWaves;

public interface ThingInSpace {
    int getAccelerationInSpace();
    Direction getDirection();
    void setDirection(Direction newDirection);
    void setAccelerationInSpace(int newAcceleration);
    SizeOfGravityWaves getSize();
}
