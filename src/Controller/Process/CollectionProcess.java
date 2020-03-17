package Controller.Process;

import Exeptions.MyException;
import Model.Accont.Player;
import Model.Cards.Card;
import Model.Cards.Hero;
import Model.Menu.*;
import Model.Primary;
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
                CardsCollection.getCardsCollection().enterMenu(CardsCollection.getCardsCollection());
            } else if (pattern.allHeroes.matcher(input).find()) {
                for (Hero hero : Primary.AllHeroes) {
                    new Print(hero.getName());
                }
                CardsCollection.getCardsCollection().enterMenu(CardsCollection.getCardsCollection());
            } else if (pattern.selectHero.matcher(input).find()) {
                new Print("Please Select Your Hero");
                String heroName = scanner.nextLine();
                Hero selected = Hero.search(heroName);
                if (MenuHandler.currentMenu.Online.getUnlockedHeroes().contains(selected)) {
                    MenuHandler.currentMenu.Online.setCurrentHero(selected);
                    CardsCollection.getCardsCollection().enterMenu(DeckMenu.getDeckMenu());
                    checkInput(selected, MenuHandler.currentMenu.Online);
                }
            } else if (pattern.back.matcher(input).find()) {
                CardsCollection.getCardsCollection().enterMenu(MainMenu.getMainMenu());
            }
        } catch (MyException e) {
            throw e;
        }
    }

    protected void checkInput(Hero hero, Player player) throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.addCard.matcher(input).find()) {
                int cardNum = 0;
                Card card = getCard();
                if (!player.getUnlockedCards().contains(card)) {
                    throw new MyException("This Card Is Lock Now");
                }
                if (player.getDecks().get(hero).size() >= 14)
                    throw new MyException("Yor Deck is Full");
                for (Card playerCard : player.getDecks().get(hero)) {
                    if (playerCard.getName().equals(card.getName())) {
                        cardNum++;
                    }
                }
                if (cardNum >= 2) {
                    throw new MyException("You Have Two of This Card in You Current Deck");
                }
                player.getDecks().get(hero).add(card);
            } else if (pattern.removeCard.matcher(input).find()) {
                Card card = getCard();
                if (!player.getDecks().get(hero).contains(card)) {
                    throw new MyException("You dont Have This in Your Deck");
                }
                if (player.getDecks().get(hero).isEmpty()) {
                    throw new MyException("You dont Have Any Card in Your Deck");
                }
                player.getDecks().get(hero).remove(card);
            } else if (pattern.deck.matcher(input).find()) {
                for (Card card : player.getDecks().get(hero)) {
                    new Print(card);
                }
            } else if (pattern.back.matcher(input).find()) {
                DeckMenu.getDeckMenu().enterMenu(CardsCollection.getCardsCollection());
            }
        } catch (MyException e) {
            throw e;
        }
    }

    public Card getCard() throws MyException {
        new Print("Card Name : ");
        try {
            return Card.search(scanner.nextLine());
        } catch (MyException e) {
            throw e;
        }
    }

}
