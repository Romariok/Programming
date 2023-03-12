package exceptions;

public class inappropriateVelocity extends RuntimeException{
    public inappropriateVelocity(){
        super("Нельзя лететь с такой скоростью, дурак.\nШтраф - у вас отбирается кошка-девочка!");
    }
}
