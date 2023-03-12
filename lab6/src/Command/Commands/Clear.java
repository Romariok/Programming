package src.Command.Commands;

import src.Command.*;

/**
 * Class for the clear command. Clears the collection
 */
public class Clear implements Command {
    Linkedlist linkedlist;

    public Clear(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.clear();
    }
}
