import Controller.Input.CheckList;
import View.Output.Output;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunnig = true;
        CheckList checkList;
        System.out.println(Output.welCome.getMassage());
        Scanner input = new Scanner(System.in);
        while (isRunnig) {
            new CheckList(input.nextLine().toLowerCase());
        }
    }
}
