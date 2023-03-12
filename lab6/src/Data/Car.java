package src.Data;

/**
 * Used to manage with car
 * @author Roman Kobelev
 */
public class Car {
    /**
     * Status of car of human being
     * @see HumanBeing
     */
    private boolean cool;

    /**
     * Constructor of Car with parameter
     * @param cool status of car
     */
    public Car(boolean cool){
        this.cool = cool;
    }

    /**
     * Constructor of Car without parameters
     */
    public Car(){

    }

    /**
     * @return status of car
     */
    public boolean getCool(){
        return this.cool;
    }

    /**
     * Set status of car
     * @param cool status of car
     */
    public void setCool(boolean cool){
        this.cool = cool;
    }

    /**
     *Used to print information about car
     */
    @Override
    public String toString(){
        return ""+this.cool;
    }

}
