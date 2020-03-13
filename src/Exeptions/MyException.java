package Exeptions;

public class MyException extends Exception {
    public MyException(String massage) {
        super(massage);
    }

    public static MyException invalidUser = new MyException("Invalid User!");
    public static MyException alreadyCreated = new MyException("Already Created!");
    public static MyException logout = new MyException("Already Created!");
    public static MyException forceStop = new MyException("Already Created!");


}


