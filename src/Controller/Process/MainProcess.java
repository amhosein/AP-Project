package Controller.Process;

import Exeptions.MyException;
import Model.MarketPlace.ShopMenu;
import Model.Menu.*;
import View.Menu.MenuHandler;

import java.io.IOException;

public class MainProcess {
    String input;

    public MainProcess(String input) {
        this.input = input;
    }

    public void MainProcess() throws MyException, IOException {
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
            } else if (MenuHandler.currentMenu instanceof DeckMenu) {
                new DeckMenuProcess(input).checkInput();
            } else if (MenuHandler.currentMenu instanceof Play) {
                new PlayMenuProcess(input).checkInput();
            }
        } catch (MyException | IOException e) {
            throw e;
        }
    }
}

