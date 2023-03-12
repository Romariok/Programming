
public class test {
    public static int counter(){
        int counter = 0;
        counter+=1;
        return counter;
    }
    public static void test(){
        for (int i = 0;i<10;i++){
            counter();
        }
    }

}
