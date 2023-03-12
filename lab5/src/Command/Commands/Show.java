package src.Command.Commands;

import src.Command.*;

/**
 * Class for the show command. Printing information about elements in collection
 */
public class Show implements Command {
    Linkedlist linkedlist;

    public Show(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.show();
    }
}
