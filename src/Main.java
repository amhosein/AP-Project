import Controller.Input.CheckList;
import View.Output.Output;
import View.Output.Print;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunnig = true;
        CheckList checkList;
        new Print(Output.welCome);
        Scanner input = new Scanner(System.in);
        while (isRunnig) {
            new CheckList(input.nextLine().toLowerCase());
        }
    }
}
