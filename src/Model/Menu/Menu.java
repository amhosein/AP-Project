package Model.Menu;

import Controller.Process.MainProcess;
import Controller.Process.Patterns;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Menu {
    public Player onlinePlayer;
    private Menu parentMenu;
    private List<Menu> subMenus = new ArrayList<>();
    private List<String> orders = new ArrayList<>();
    protected String name;
    private static boolean inputUser = true;

    protected Menu(String name) {
        this.name = name;
    }

    public void addSubMenu(Menu subMenu) {
        if (subMenu == null)
            return;
        this.subMenus.add(subMenu);
        subMenu.parentMenu = this;
    }

    public void setOnlinePlayer(Player onlinePlayer) {
        this.onlinePlayer = onlinePlayer;
    }

    public void setOrders(String order) {
        this.orders.add(order);
    }

    public List<String> menuOrders() {
        return this.orders;
    }

    public void enterMenu(Menu subMenu) {
        subMenu.setOnlinePlayer(this.onlinePlayer);
        MenuHandler.currentMenu = subMenu;
        subMenu.process();
    }

    public void exitMenu() {
        parentMenu.setOnlinePlayer(this.onlinePlayer);
        MenuHandler.currentMenu = parentMenu;
        parentMenu.process();
    }

    public String getName() {
        return name;
    }

    protected void process() {
        Scanner input = new Scanner(System.in);
        while (inputUser) {
            try {
                new Print().printMenu(this);
                String in = input.nextLine();
                if (in.toLowerCase().equals("back"))
                    exitMenu();
                if (in.toLowerCase().equals("force stop")) {
                    new Print("Are you Sure ? :( \nYes/No");
                    if (input.nextLine().toLowerCase().equals("yes")) {
                        new Print("Come on Man \n Let's Have A Cup Of Tea! :'( ");
                        new Print("Sure Sure ? :(( ");
                        if (input.nextLine().toLowerCase().equals("yes")) {
                            if (onlinePlayer != null) {
                                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.exit);
                                onlinePlayer.save();
                            }
                            inputUser = false;
                            break;
                        }
                    }
                }
                new MainProcess(in.toLowerCase()).MainProcess();
            } catch (MyException | IOException e) {
                new Print(e.getMessage());
            } finally {
                if (onlinePlayer != null) {
                    onlinePlayer.save();
                }
            }
        }
    }

    public List<String> getOrders() {
        return orders;
    }
}
