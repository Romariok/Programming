package Command.Commands;

import Command.*;
import Data.HumanBeing;
import DataStructure.Response;

import java.util.LinkedList;

/**
 * Class for the remove_greater command. Removing elements in collection whose id is greater than specified
 */
public class Remove_greater extends Command_abstract implements CommandResponse {
    private String output;

    public Remove_greater(){
    }
    @Override
    public void execute() {
        Integer id = Integer.parseInt(getArgs()[0]);
        LinkedList<HumanBeing> humans = getCollectionManager().getCollection();
        int counting = 0;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getId() > id) {
                counting++;
                humans.remove(i);
            }
        }
        output = "Удалено " + counting + " элементов, id которых был больше " + id + "!\n";
    }

    @Override
    public Response getResponse(){
        return new Response("remove greater", output);
    }
}
