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
    }

    public void call() {
        System.out.println(name);
        for (String order : menuOrders()) {
            System.out.println(order);
        }
        this.process();
    }
}

