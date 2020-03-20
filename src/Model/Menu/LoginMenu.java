package Model.Menu;

public class LoginMenu extends Menu {
    private static LoginMenu loginMenu;

    public static LoginMenu getLoginMenu() {
        if (loginMenu == null) {
            loginMenu = new LoginMenu("login Menu");
        }
        return loginMenu;
    }

    public LoginMenu(String name) {
        super(name);
        setOrders("1.Sign in");
        setOrders("2.Sing up");
        setOrders("3.Force Stop");
    }

    public void call() {
        this.process();
    }
}

