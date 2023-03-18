package src;
import src.server.Command.*;
import src.server.Command.Commands.*;

/**
 * @author Roman Kobelev
 */
public class LinkedListRunner{
    /**
     * Main class for entering in interactive mode for work with collection
     * @param argx
     */
    public static void main(String[] argx){
        Linkedlist linkedlist = new Linkedlist(argx[0], argx[1]);

        Developer developer = new Developer(
                new Add(linkedlist),
                new Exit(linkedlist),
                new Help(linkedlist),
                new Info(linkedlist),
                new Show(linkedlist),
                new Save(linkedlist),
                new Clear(linkedlist),
                new Sum_of_impact_speed(linkedlist),
                new Remove_by_id(linkedlist),
                new Insert_at(linkedlist),
                new Update(linkedlist),
                new Remove_greater(linkedlist),
                new Remove_lower(linkedlist),
                new Execute_script(linkedlist),
                new Filter_starts_with_soundtrack_name(linkedlist),
                new Count_greater_than_car(linkedlist)
        );

        linkedlist.interactive_mod(developer);
    }
}
