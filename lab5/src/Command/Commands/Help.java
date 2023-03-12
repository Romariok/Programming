package src.Command.Commands;

import src.Command.*;

/**
 * Class for the help command. Print list of commands
 */
public class Help implements Command {
    Linkedlist linkedlist;

    public Help(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(){
        linkedlist.help();
    }
}
