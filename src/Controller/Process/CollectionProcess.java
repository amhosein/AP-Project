package Controller.Process;

import Exeptions.MyException;
import Model.Accont.Player;
import Model.Cards.Card;
import Model.Cards.Hero;
import Model.Menu.*;
import Model.Primary;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.Scanner;

public class CollectionProcess extends MainProcess {
    Scanner scanner = new Scanner(System.in);

    public CollectionProcess(String input) {
        super(input);
    }

    protected void checkInput() throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.allCards.matcher(input).find()) {
                for (Card card : Primary.allCards) {
                    new Print(card);
                }
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.allCards);
                CardsCollection.getCardsCollection().enterMenu(CardsCollection.getCardsCollection());
            } else if (pattern.allHeroes.matcher(input).find()) {
                for (Hero hero : Primary.allHeroes) {
                    new Print(hero.getName());
                }
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.allHeroes);
                CardsCollection.getCardsCollection().enterMenu(CardsCollection.getCardsCollection());
            } else if (pattern.selectHero.matcher(input).find()) {
                new Print("Please Select Your Hero");
                String heroName = scanner.nextLine();
                Hero selected = Hero.search(heroName);
                for (Hero hero : MenuHandler.currentMenu.onlinePlayer.getUnlockedHeroes()) {
                    if (hero.getName().equals(selected.getName())) {
                        new Logger(MenuHandler.currentMenu.onlinePlayer, selected, Logs.selectHero);
                        MenuHandler.currentMenu.onlinePlayer.setCurrentHero(selected);
                        CardsCollection.getCardsCollection().enterMenu(DeckMenu.getDeckMenu());
                    }
                }
                throw new MyException("You dont have this hero");
            } else if (pattern.back.matcher(input).find()) {
                throw MyException.back;
            }
        } catch (MyException e) {
            throw e;
        }
    }

}
