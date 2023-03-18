package src.server.Command.Commands;

import src.server.Command.*;
/**
 * Class for the remove_lower command. Removing elements in collection whose id is lower than specified
 */
public class Remove_lower implements CommandWithInteger {
    Linkedlist linkedlist;

    public Remove_lower(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(int id){
        linkedlist.remove_lower(id);
    }
}
