package src.Command.Commands;

import src.Command.*;

/**
 * Class for the update command. Updating element by his index
 */
public class Update implements CommandWithInteger {
    Linkedlist linkedlist;

    public Update(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(int id){
        linkedlist.update(id);
    }
}
