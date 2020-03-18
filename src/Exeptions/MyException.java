package Exeptions;

import javafx.scene.media.MediaException;

public class MyException extends Exception {
    public MyException(String massage) {
        super(massage);
    }



    public static MyException invalidUser = new MyException("Invalid User!");
    public static MyException alreadyCreated = new MyException("Already Created!");
    public static MyException forceStop = new MyException("Okay Bye :/");
    public static MyException invalidHero = new MyException("Invalid Hero");
    public static MyException invalidCard = new MyException("Invalid Card");
    public static MyException back = new MyException("Back");


}


