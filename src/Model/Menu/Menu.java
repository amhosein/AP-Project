package Model.Menu;

import Controller.Process.MainProcess;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    public Player Online;
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

    public void setOnline(Player online) {
        Online = online;
    }

    public void setOrders(String order) {
        this.orders.add(order);
    }

    public List<String> menuOrders() {
        return this.orders;
    }

    public void enterMenu(Menu subMenu) {
        subMenu.setOnline(this.Online);
        MenuHandler.currentMenu = subMenu;
        new Print().printMenu(subMenu);
        subMenu.process();
    }

    public String getName() {
        return name;
    }

    protected void process() {
        boolean inputUser = true;
        Scanner input = new Scanner(System.in);
        while (inputUser) {
            try {
                new MainProcess(input.nextLine().toLowerCase()).MainProcess();
            } catch (MyException e) {
                new Print(e.getMessage());
                if (e == MyException.forceStop) {
                    inputUser = false;
                }
            }
        }
    }

    public List<String> getOrders() {
        return orders;
    }
}