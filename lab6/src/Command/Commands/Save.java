package src.Command.Commands;

import src.Command.*;

/**
 * Class for the save command. Saving collection in file
 */
public class Save implements Command {
    Linkedlist linkedlist;

    public Save(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.save();
    }
}
