package src.server.Command.Commands;

import src.server.Command.*;

/**
 * Class for tha add command. Add an element.
 */
public class Add implements Command {
    Linkedlist linkedlist;

    public Add(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.add();
    }
}
