package src.Command.Commands;

import src.Command.*;

/**
 * Class for the remove_greater command. Removing elements in collection whose id is greater than specified
 */
public class Remove_greater implements CommandWithInteger {
    Linkedlist linkedlist;

    public Remove_greater(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(int id){
        linkedlist.remove_greater(id);
    }
}
