package Controller.Process;

import Exeptions.MyException;
import Model.Menu.*;
import View.Menu.MenuHandler;

public class MainProcess {
    String input;

    public MainProcess(String input) {
        this.input = input;
    }

    public void MainProcess() throws MyException {
        try {
            if (MenuHandler.currentMenu instanceof LoginMenu) {
                new LoginProcess(input).checkInput();
            } else if (MenuHandler.currentMenu instanceof MainMenu) {
                new MainMenuProcess(input).checkInput();
            } else if (MenuHandler.currentMenu instanceof CardsCollection) {
                new CollectionProcess(input).checkInput();
            } else if (MenuHandler.currentMenu instanceof Profile) {
                new ProfileProcess(input).checkInput();
            } else if (MenuHandler.currentMenu instanceof ShopMenu) {
                new ShopProcess(input).checkInput();
            }
        } catch (MyException e) {
            throw e;
        }
    }
}
