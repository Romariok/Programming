package src.Command;

import src.Converter.*;
import src.Data.*;

import src.setVariables.*;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * The Linkedlist class is collection based on LinkedList
 * This class contains interactive mode method to work with commands
 *
 * @author Roman Kobelev
 * @since 14.02.2023
 * @version 69
 * @see HumanBeing
 */
public class Linkedlist {
    /**
     * LinkedList collection that contains HumanBeing objects
     */
    private LinkedList<HumanBeing> humans = new LinkedList<>();
    /**
     * Linked list that will contain unsaved data
     */
    LinkedList<HumanBeing> old_humans = new LinkedList<>();
    /**
     * Counter for lines in script
     */
    public static int count = 0;
    /**
     * Value for initialized time
     */
    private final ZonedDateTime indate;
    /**
     * ParserXML used for read and write data to file
     * @see ParserXML
     */
    private ParserXML parserXML;
    /**
     * Array that contains lines of scripts
     */
    public static String[] script_input = new String[]{};
    /**
     * New parser that will save data to file silently
     */
    ParserXML parserXML1;
    /**
     * Initialize {@code Comparator}
     */
    Comparator<HumanBeing> comparator = (o1, o2) -> o2.compareTo(o1);

    /**
     * Constructor of {@code Linkedlist} where we initialize date of creation of collection
     * Also checking file and loading data from xml file
     * @param path path to the file
     * @see ParserXML
     */
    public Linkedlist(String path, String path1){
        try{
            if (path == null) throw new FileNotFoundException();
        }
        catch (FileNotFoundException ex){
            System.out.println("Введите путь до файла в виде аргумента!");
            System.exit(1);
        }
        indate = ZonedDateTime.now();

        parserXML1 = new ParserXML(path1);
        silent_load();

        parserXML = new ParserXML(path);
        load();

        boolean eq = old_humans.containsAll(humans) && humans.containsAll(old_humans);
        if (getAnswer(eq)){
            humans = old_humans;
            save();
            System.out.println("Несохранённые данные востановлены!");
        }
        else silent_save();
    }
    private Boolean getAnswer(boolean bool) {
        if (!bool){
            System.out.println("Хотите лы вы сохранить несохранённые изменения?");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            switch (line){
                case "Да":
                    return true;
                case "Нет":
                    return false;
                default:
                    System.out.println("Введено некорректное значение! Введите значение ещё раз!");
                    return getAnswer(bool);

            }
        }
        return false;
    }
    /**
     * Used to print list of commands
     */
    public void help(){
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("insert_at index {element} : добавить новый элемент в заданную позицию");
        System.out.println("remove_greater id : удалить из коллекции все элементы, у которого id больше заданного");
        System.out.println("remove_lower id : удалить из коллекции все элементы, id которых меньше, чем заданный");
        System.out.println("sum_of_impact_speed` : вывести сумму значений поля impactSpeed для всех элементов коллекции");
        System.out.println("count_greater_than_car car : вывести количество элементов, значение поля car которых больше заданного");
        System.out.println("filter_starts_with_soundtrack_name soundtrackName : вывести элементы, значение поля soundtrackName которых начинается с заданной подстроки\n");
    }

    /**
     * Used to print information about collection
     */
    public void info(){
        System.out.println("Тип коллекции: " + humans.getClass() + "\n"
                + "Дата инициализации: " + indate + "\n"
                + "Размер коллекции: " + humans.size() + "");
    }

    /**
     * Used to print all elements that contains in collection
     */
    public void show() {
        if (humans.size() != 0) humans.forEach(System.out::println);
        else System.out.println("Коллекция пуста.");
    }

    /**
     * Used to exit program without saving our collection in file
     */
    public void exit(){
        silent_load();
        boolean eq = old_humans.containsAll(humans) && humans.containsAll(old_humans);
        if (getAnswer(eq)){
            humans = old_humans;
            save();
            silent_save();
        }
        System.exit(1);
    }

    /**
     * Used to add a new element in collection
     */
    public void add() {
        HumanBeing humanBeing = new HumanBeing();
        setData2Object(humanBeing);
        humans.add(humanBeing);
        humans.sort(comparator);
        System.out.println("Ваш элемент успешно добавлен в коллекцию!");
        silent_save();
    }

    /**
     * Used to save collection in file
     */
    public void save(){
        try{
            parserXML.writeData(humans);

        }
        catch(Exception ex){
            System.out.println("Возникла непредвиденная ошибка! Файл не сохранился");
            System.exit(1);
        }
        System.out.println("Файл успешно сохранён!");


    }
    private void silent_save(){
        try{
            parserXML1.writeData(humans);
        }
        catch(Exception ex){
            System.out.println("Возникла непредвиденная ошибка! Файл не сохранился");
            System.exit(1);
        }
    }
    /**
     * Used to clear collection
     */
    public void clear(){
        humans.clear();
        System.out.println("Коллекция успешна очищена!");
        silent_save();
    }

    /**
     * Used to load data from file to collection
     */
    private void load(){
        try{
            parserXML.parseData(humans);

        }
        catch(Exception ex){
            System.out.println("Возникла непредвиденная ошибка! Файл не загрузился!");
            System.exit(1);
        }
        System.out.println("Файл успешно загружен в коллекцию!");
    }
    private void silent_load(){
        try{
            parserXML1.parseData(old_humans);

        }
        catch(Exception ex){
            System.out.println("Возникла непредвиденная ошибка! Файл не загрузился!");
            System.exit(1);
        }
    }

    /**
     * Used to remove an element by index
     * @param index
     */
    public void remove_by_id(int index){
        try{
            humans.remove(index);
        }
        catch(Exception ex){
            System.out.println("Возникла непредвиденная ошибка! Элемент не удалён!");
        }
        System.out.println(index + "-й элемент успешно удалён!");
        silent_save();
    }

    /**
     * Used to update an element by id
     * @param id
     */
    public void update(int id){
        HumanBeing humanBeing = null;
        for(int i=0;i<humans.size();i++){
            if(id == humans.get(i).getId()){
               humanBeing = humans.get(i);
            }
        }
        if (humanBeing != null){
            setData2Object(humanBeing);
            System.out.println("Ваш элемент успешно обновлён!");
        }
        else{
            System.out.println("Объекта по вашему id не существует в коллекции!");
        }

    }

    /**
     * Used to print sum of impact speed of elements in collection
     */
    public void sum_of_impact_speed(){
        int sum = 0;
        for (int i=0;i< humans.size();i++){
            sum+=humans.get(i).getImpactSpeed();
        }
        System.out.println("Сумма значений поля impactSpeed для всех элементов коллекции: " + sum);
    }

    /**
     * Used to execute script
     * @param path path to file
     */
    public void execute_script(String path){
        File script = new File(path);
        char[] array = new char[(int)script.length()];
        try (InputStreamReader isr = new InputStreamReader( new FileInputStream(script), StandardCharsets.UTF_8)) {
            isr.read(array);
            String readedFile = String.valueOf(array);
            script_input = readedFile.split("\n");
        }
        catch (IOException ex){
            ex.getStackTrace();
            System.out.println("Возникла IOException! Скрипт не считан!");
        }

    }

    /**
     * Used to remove elements in collection whose id is greater than specified
     * @param id
     */
    public void remove_greater(int id){
        int counting = 0;
        for (int i = 0;i < humans.size();i++){
            if (humans.get(i).getId() > id){
                counting++;
                humans.remove(i);
            }
        }
        System.out.println("Удалено "+ counting + " элементов, id которых был больше "+id+"!");
    }
    /**
     * Used to remove elements in collection whose id is lower than specified
     * @param id
     */
    public void remove_lower(int id){
        int counting = 0;
        for (int i = 0;i < humans.size();i++){
            if (humans.get(i).getId() < id){
                counting++;
                humans.remove(i);
            }
        }
        System.out.println("Удалено "+ counting + " элементов, id которых был меньше "+id+"!");
    }

    /**
     * Used to remove elements in collection whose status of car greater than specified
     * @param cool
     */
    public void count_greater_than_car(boolean cool){
        int counting = 0;
        if (!cool){
            for (int i = 0;i < humans.size();i++){
                if (humans.get(i).getCar().getCool()){
                    counting++;
                }
            }
        }
        System.out.println("Количество элементов, значение поля car которых больше "+cool+" : "+counting);
    }

    /**
     * Used to insert a new element by index
     * @param index
     */
    public void insert_at(int index){
        HumanBeing humanBeing = new HumanBeing();
        setData2Object(humanBeing);
        try {
            humans.add(index, humanBeing);
        }
        catch(Exception ex){
            ex.getStackTrace();
            System.out.println("Возникла ошибка при добавлении элемента на "+ index+"-ю позицию!");
        }
        humans.sort(comparator);
        System.out.println("Ваш элемент успешно добавлен в коллекцию на "+index+" позицию!");
    }

    /**
     *Used to print items whose soundtrackName field value starts with the specified substring
     * @param soundtrackName
     */
    public void filter_starts_with_soundtrack_name(String soundtrackName){
        for (int i=0;i< humans.size();i++){
            if (humans.get(i).getSoundtrackName().contains(soundtrackName)){
                System.out.println(humans.get(i).toString());
            }
        }
    }

    /**
     * Used to set values of fields to {@code HumanBeing} object
     * @param humanBeing
     */
    private void setData2Object(HumanBeing humanBeing){
        humanBeing.setCreationDate();
        humanBeing.setName(SetName.initializeName());
        Coordinates coordinates = new Coordinates();
        coordinates.setX(setCoordinates.setCoordinateX());
        coordinates.setY(setCoordinates.setCoordinateY());
        humanBeing.setCoordinates(coordinates);
        humanBeing.setRealHero(setRealHero.initializeRealHero());
        humanBeing.setHasToothpick(setHasToothpick.initializeHasToothpick());
        humanBeing.setImpactSpeed(setImpactSpeed.initializeImpactSpeed());
        humanBeing.setSoundtrackName(setSoundtrackName.initializeSoundtrackName());
        humanBeing.setWeaponType(setWeaponType.initializeWeaponType());
        humanBeing.setMood(setMood.initializeMood());
        Car car = new Car();
        car.setCool(setCar.initializeCar());
        humanBeing.setCar(car);
    }

    /**
     * @return lines of script
     */
    public static String[] getScript_input(){
        return script_input;
    }

    /**
     * Starts interactive mode to manage with command
     * @param developer
     */
    public void interactive_mod(Developer developer){
        count = 0;
        while (true){
            String[] line;
            if (count < script_input.length && script_input.length != 0){
                line = script_input[count].split(" ");
                count++;
                if (count == script_input.length){
                    count = 0;
                    script_input = new String[]{};
                }
            }
            else{
                Scanner scanner = new Scanner(System.in);
                line = scanner.nextLine().split(" ");
            }
            switch (line[0].trim()){
                case "add":
                    developer.add();
                    silent_save();
                    break;
                case "exit":
                    developer.exit();
                    break;
                case "help":
                    developer.help();
                    break;
                case "info":
                    developer.info();
                    break;
                case "show":
                    developer.show();
                    break;
                case "save":
                    developer.save();;
                    break;
                case "clear":
                    developer.clear();
                    silent_save();
                    break;
                case "sum_of_impact_speed":
                    developer.sum_of_impact_speed();
                    break;
                case "remove_by_id":
                    developer.remove_by_id(Integer.parseInt(line[1]));
                    silent_save();
                    break;
                case "update":
                    developer.update(Integer.parseInt(line[1]));
                    silent_save();
                    break;
                case "execute_script":
                    developer.execute_script(line[1]);
                    silent_save();
                    break;
                case "remove_lower":
                    developer.remove_lower(Integer.parseInt(line[1]));
                    silent_save();
                    break;
                case "remove_greater":
                    developer.remove_greater(Integer.parseInt(line[1]));
                    silent_save();
                    break;
                case "count_greater_than_car":
                    try{
                        developer.count_greater_than_car(Boolean.parseBoolean(line[1]));
                    }
                    catch (Exception ex){
                        ex.getStackTrace();
                        System.out.println("Неверное значение для типа boolean!");
                    }
                    break;
                case "insert_at":
                    developer.insert_at(Integer.parseInt(line[1]));
                    silent_save();
                    break;
                case "filter_starts_with_soundtrack_name":
                    developer.filter_starts_with_soundtrack_name(line[1].trim());
                    break;
                default:
                    System.out.println("Данная система не знает команды "+line[0].trim()+"!\nДля списка команд впишите 'help'");
            }
        }
    }

}
