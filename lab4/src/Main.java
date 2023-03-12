import Live.*;
import Objects.*;
import Others.State;

public class Main {
    public static void main(String[] args) {
        Telescope telescope = new Telescope("Телескоп", Materials.PLASTIC, State.STAND, PlanetaryGravity.MOON, 10);
        Astronomers astronomers = new Astronomers("Астрономы", Mood.CONCENTRATED, State.OBSERVE, "moon language");
        Spaceship spaceship = new Spaceship("кораблик", Materials.METAL, State.FLY, PlanetaryGravity.EARTH, 10, 1, 1000000);
        Spruts spruts = new Spruts("Спрутс", Mood.HAPPY, State.SIT, "moon language");
        Rjigl rjigl = new Rjigl("Комиссар Ржигль", Mood.CALM, State.WALK, "moon language");

        astronomers.setStateToSomething(telescope, State.USE);
        String checkObjectInSpace = astronomers.getDestination(spaceship, telescope);
        String checkCallToSpruts = spruts.getCall(checkObjectInSpace);
        rjigl.getCall(checkCallToSpruts);
        }

    }


