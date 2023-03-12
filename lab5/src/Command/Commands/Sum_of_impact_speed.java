package src.Command.Commands;

import src.Command.*;

/**
 * Class for the sum_of_impact_speed. Printing sum of impact speed of elements in collection
 */
public class Sum_of_impact_speed implements Command {
    Linkedlist linkedlist;

    public Sum_of_impact_speed(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.sum_of_impact_speed();
    }
}
