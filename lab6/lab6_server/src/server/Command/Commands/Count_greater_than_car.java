package src.server.Command.Commands;

import src.server.Command.*;

/**
 * Class for the count_greater_than_car command. Remove elements in collection whose status of car greater than specified
 */
public class Count_greater_than_car implements CommandWithBoolean {
    Linkedlist linkedlist;

    public Count_greater_than_car(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(boolean car){
        linkedlist.count_greater_than_car(car);
    }
}
