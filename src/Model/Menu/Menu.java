package Model.Menu;

import Controller.Process.MainProcess;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    public Player onlinePlayer;
    private Menu parentMenu;
    private List<Menu> subMenus = new ArrayList<>();
    private List<String> orders = new ArrayList<>();
    protected String name;

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
        boolean inputUser = true;
        Scanner input = new Scanner(System.in);
        while (inputUser) {

            try {
                new Print().printMenu(this);
                new MainProcess(input.nextLine().toLowerCase()).MainProcess();
            } catch (MyException | IOException e) {
                if (e == MyException.forceStop) {
                    inputUser = false;
                }
                if (e == MyException.back) {
                    exitMenu();
                }
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
