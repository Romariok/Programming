package src.server.Command.Commands;

import src.server.Command.*;

/**
 * Class for the insert_at command. Insert element in collection by index
 */
public class Insert_at implements CommandWithInteger {
    Linkedlist linkedlist;

    public Insert_at(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(int index){
        linkedlist.insert_at(index);
    }
}
