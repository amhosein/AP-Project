
import Controller.Menu.LoginMenu;
import Model.Primary;
import View.Menu.MenuHandler;
import View.Output.Output;
import View.Output.Print;

public class Main {
    public static void main(String[] args) {
        Primary.init();
        new Print(Output.welCome);
        MenuHandler.initMenu();
    }
}
