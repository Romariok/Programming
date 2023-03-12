package src.Command.Commands;

import src.Command.*;

/**
 * Class for the filter_starts_with_soundtrack_name. Print items whose soundtrackName field value starts with the specified substring
 */
public class Filter_starts_with_soundtrack_name implements CommandWithString {
    Linkedlist linkedlist;

    public Filter_starts_with_soundtrack_name(Linkedlist linkedlist){
        this.linkedlist = linkedlist;
    }

    @Override
    public void execute(String soundtrackName){
        linkedlist.filter_starts_with_soundtrack_name(soundtrackName);
    }
}
