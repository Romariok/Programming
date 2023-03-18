package src.server.Command.Commands;

import src.server.Command.*;

/**
 * Class for the exit command. Exit program without saving our collection in file
 */
public class Exit implements Command {
    Linkedlist linkedlist;

    public Exit(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.exit();
    }
}
