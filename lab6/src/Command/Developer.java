package src.Command;

/**
 * The {@code Developer} class used to provide connection with commands all and their realizations
 * @author Roman Kobelev
 */
public class Developer {
    Command add;
    Command exit;
    Command help;
    Command info;
    Command show;
    Command save;
    Command clear;
    Command sum_of_impact_speed;
    CommandWithInteger remove_by_id;
    CommandWithInteger update;
    CommandWithInteger remove_greater;
    CommandWithInteger remove_lower;
    CommandWithInteger insert_at;
    CommandWithString execute_script;
    CommandWithString filter_starts_with_soundtrack_name;
    CommandWithBoolean count_greater_than_car;

    /**
     * Constructor of {@code Developer} class with parameters
     * @param add
     * @param exit
     * @param help
     * @param info
     * @param show
     * @param save
     * @param clear
     * @param sum_of_impact_speed
     * @param remove_by_id
     * @param insert_at
     * @param update
     * @param remove_greater
     * @param remove_lower
     * @param execute_script
     * @param filter_starts_with_soundtrack_name
     * @param count_greater_than_car
     */
    public Developer(Command add, Command exit, Command help, Command info, Command show, Command save, Command clear, Command sum_of_impact_speed,
                     CommandWithInteger remove_by_id, CommandWithInteger insert_at,CommandWithInteger update, CommandWithInteger remove_greater, CommandWithInteger remove_lower,CommandWithString execute_script,
                     CommandWithString filter_starts_with_soundtrack_name, CommandWithBoolean count_greater_than_car){
        this.add = add;
        this.exit = exit;
        this.help = help;
        this.info = info;
        this.show = show;
        this.save = save;
        this.clear = clear;
        this.sum_of_impact_speed = sum_of_impact_speed;
        this.remove_by_id = remove_by_id;
        this.remove_greater = remove_greater;
        this.remove_lower = remove_lower;
        this.update = update;
        this.execute_script = execute_script;
        this.count_greater_than_car = count_greater_than_car;
        this.filter_starts_with_soundtrack_name = filter_starts_with_soundtrack_name;
        this.insert_at = insert_at;
    }

    public void add(){
        add.execute();
    }
    public void exit(){
        exit.execute();
    }
    public void help(){
        help.execute();
    }
    public void info(){
        info.execute();
    }
    public void show(){
        show.execute();
    }
    public void save(){
        save.execute();
    }
    public void clear(){
        clear.execute();
    }
    public void sum_of_impact_speed(){
        sum_of_impact_speed.execute();
    }
    public void remove_by_id(int id){
        remove_by_id.execute(id);
    }
    public void remove_lower(int id){
        remove_lower.execute(id);
    }
    public void remove_greater(int id){
        remove_greater.execute(id);
    }
    public void update(int id){
        update.execute(id);
    }
    public void execute_script(String path){
        execute_script.execute(path);
    }
    public void count_greater_than_car(boolean car){
        count_greater_than_car.execute(car);
    }
    public void filter_starts_with_soundtrack_name(String soundtrackName){
        filter_starts_with_soundtrack_name.execute(soundtrackName);
    }
    public void insert_at(int index){
        insert_at.execute(index);
    }


}
