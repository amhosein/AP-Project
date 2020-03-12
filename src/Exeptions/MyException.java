package Exeptions;

public class MyException extends Exception {
    public MyException(String massage) {
        super(massage);
    }

    public static MyException invalidUser = new MyException("Invalid User!");
    public static MyException alreadyCreated = new MyException("Already Created!");


}


