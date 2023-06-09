package src.Command.Commands;

import src.Command.*;


/**
 * Class for the info command. Print information about collection
 */
public class Info implements Command {
    Linkedlist linkedlist;

    public Info(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.info();
    }
}
