
import Model.Primary;
import View.Menu.MenuHandler;
import View.Output.Output;
import View.Output.Print;

public class Main {
    public static void main(String[] args) {
        new Print(Output.welCome);
        Primary.init();
        MenuHandler.initMenu();
    }
}
