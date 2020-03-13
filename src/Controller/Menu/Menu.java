package Controller.Menu;

import Model.Accont.Player;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static Player Online;
    private Menu parentMenu;
    private List<Menu> subMenus = new ArrayList<>();
    private List<String> orders;

    protected void addSubMenu(Menu subMenu) {
        this.subMenus.add(subMenu);
        subMenu.parentMenu = this;
    }

}
