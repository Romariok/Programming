import Live.*;
import Objects.*;
import Others.*;

public class Main1 {
    public static void main(String[] args) throws Throwable{
        Telescope4 telescope = new Telescope4("Телескоп", Materials.PLASTIC, State.STAND, PlanetaryGravity.MOON, 10, Telescope4.Angles.CENTER);
        Screen screen = new Screen("Экран", Materials.GLASS, State.STAND, PlanetaryGravity.MOON);
        GravityLocator gravityLocator = new GravityLocator("Гравитационный локатор", Materials.METAL, State.STAND, PlanetaryGravity.MOON);
        Astronomers4 astronomers = new Astronomers4("Астрономы", Mood.CONCENTRATED, State.OBSERVE, "moon language");
        Meteorite meteorite1 = new Meteorite("Метеор 1", Materials.SPACESTONE, State.FLY, SizeOfGravityWaves.SMALL, PlanetaryGravity.NONE, Direction.FROMPLANET, 10, 1, 500000, 0);
        Meteorite meteorite2 = new Meteorite("Метеор 2", Materials.SPACESTONE, State.FLY, SizeOfGravityWaves.MEDIUM, PlanetaryGravity.NONE, Direction.FROMPLANET, 10, 1, 200000, -1);
        Spaceship4 spaceship = new Spaceship4("Корабль Знайки", Materials.METAL, State.FLY, 25, SizeOfGravityWaves.BIG, PlanetaryGravity.EARTH, PartsOfMoon.NOTINMOON, Direction.FROMPLANET, 10, 1, 1000000, 0);
        Spaceship4 spaceship1 = new Spaceship4("Корабль Незнайки и Пончика", Materials.METAL, State.STAND, 2, SizeOfGravityWaves.BIG, PlanetaryGravity.MOON, PartsOfMoon.SHORE, Direction.TOWARDSPLANET, 10, 1, 1, 0);
        Spruts spruts = new Spruts("Спрутс", Mood.HAPPY, State.SIT, "moonLanguage");
        Rjigl rjigl = new Rjigl("Комиссар Ржигль", Mood.CALM, State.WALK, "moonLanguage");
        PeopleInSpaceship peopleInSpaceship = new PeopleInSpaceship("Знайка, Фуксия и Селедочка", Mood.HAPPY, State.WALK, "earth language", spaceship);

        peopleInSpaceship.AgreeOnLandingPlace();
        astronomers.setStateToSomething(telescope, State.USE);
        astronomers.setStateToSomething(screen, State.USE);
        astronomers.setStateToSomething(gravityLocator, State.USE);
        astronomers.exploreObject(meteorite1, telescope, screen, gravityLocator);
        astronomers.exploreObject(meteorite2, telescope, screen, gravityLocator);
        if (telescope.getAngles()== Telescope4.Angles.CENTER){
            //        СТАРАЯ ИСТОРИЯ
            String checkObjectInSpace = astronomers.exploreObject(spaceship, telescope, screen, gravityLocator);
            String checkCallToSpruts = spruts.getCall(checkObjectInSpace);
            rjigl.getCall(checkCallToSpruts);
//        СТАРАЯ ИСТОРИЯ ЗАКОНЧИЛАСЬ
            spaceship.setPlanetaryGravity(PlanetaryGravity.NONE);


            spaceship.setAccelerationInSpace(-1);
            spaceship.setDirection(Direction.TOWARDSPLANET);
            if (spaceship.rotationInSpace && spaceship.getAccelerationInSpace()<0){
                astronomers.awarness(spaceship);
                spaceship.setPlanetaryGravity(PlanetaryGravity.MOON);
                spaceship.setAccelerationInSpace(0);
                gravityLocator.getVolume(spaceship, astronomers);
                gravityLocator.getWeight(spaceship, astronomers);
                astronomers.saidAboutNumberOfPeople(spaceship);
                if (peopleInSpaceship.AgreeOnLandingPlace){
                    spaceship.seekingWhileLooping(24, spaceship1);
                    System.out.println("Конец!");
                }
                else {
                    System.out.println(spaceship.getName()+": А куда мы сядем? Мы этого не обговаривали!");
                }
            }
            else{
                System.out.println(spaceship.getName()+" пролетел мимо планеты\nКонец!!");
            }
        }
        else{
            System.out.println(astronomers.getName()+" смотрели в другую сторону и не увидели корабля");
            spaceship.setPlanetaryGravity(PlanetaryGravity.NONE);

            spaceship.setAccelerationInSpace(-1);
            spaceship.setDirection(Direction.TOWARDSPLANET);
            spaceship.setPlanetaryGravity(PlanetaryGravity.MOON);
            spaceship.setAccelerationInSpace(0);
            if (peopleInSpaceship.AgreeOnLandingPlace){
                spaceship.seekingWhileLooping(24, spaceship1);
                System.out.println("Конец!");
            }
            else {
                System.out.println(spaceship.getName()+": А куда мы сядем? Мы этого не обговаривали!");
            }
        }

    }

}