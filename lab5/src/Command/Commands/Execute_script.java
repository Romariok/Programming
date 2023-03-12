package src.Command.Commands;

import src.Command.*;

/**
 * Class for the execute_script command. Execute script.
 */
public class Execute_script implements CommandWithString {
    Linkedlist linkedlist;

    public Execute_script(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(String path){
        linkedlist.execute_script(path);
    }
}
