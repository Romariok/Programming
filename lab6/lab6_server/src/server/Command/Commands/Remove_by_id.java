package src.server.Command.Commands;

import src.server.Command.*;

/**
 * Class for the remove_by_id command. Removing element by id
 */
public class Remove_by_id implements CommandWithInteger {
    Linkedlist linkedlist;

    public Remove_by_id(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(int id){
        linkedlist.remove_by_id(id);
    }
}
