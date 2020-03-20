package Model.Menu;

import Exeptions.MyException;
import Model.Cards.Card;
import Model.Cards.Hero;
import Model.Primary;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;

import javax.naming.MalformedLinkException;

public class DeckMenu extends Menu {
    private static DeckMenu deckMenu;

    public static DeckMenu getDeckMenu() {
        if (deckMenu == null) {
            deckMenu = new DeckMenu("Deck Menu");
        }
        return deckMenu;
    }

    public DeckMenu(String name) {
        super(name);
        setOrders("1.Add Card");
        setOrders("2.Remove Card");
        setOrders("3.Deck");
        setOrders("4.Can Add");
        setOrders("5.Back");
    }

    public void addCard(Card card, Hero hero) throws MyException {
        int cardNum = 0;
        for (Card playerCards : onlinePlayer.getUnlockedCards()) {
            if (playerCards.getName().equals(card.getName())) {
                if (onlinePlayer.getDecks().get(hero.getName()).size() >= 14)
                    throw new MyException("Yor Deck is Full");
                for (Card playerCard : onlinePlayer.getDecks().get(hero.getName())) {
                    if (playerCard.getName().equals(card.getName())) {
                        cardNum++;
                    }
                }
                if (cardNum >= 2) {
                    throw new MyException("You Have Two of This Card in You Current Deck");
                }
                for (Hero hero1 : Primary.allHeroes) {
                    if (!hero.getName().equals(hero1.getName())) {
                        if (hero1.getSpecialCards().contains(card))
                            throw new MyException("Its special Card for anOther Hero!");
                    }
                }
                new Logger(MenuHandler.currentMenu.onlinePlayer, card, Logs.addToDeck);
                onlinePlayer.getDecks().get(hero.getName()).add(card);
                return;
            }
        }
        throw new MyException("This Card is Lock Now");

    }

    public void remove(Card card, Hero hero) throws MyException {
        boolean Contains = false;
        for (Card decksCard : onlinePlayer.getDecks().get(hero.getName())) {
            if (decksCard.getName().equals(card.getName())) {
                new Logger(MenuHandler.currentMenu.onlinePlayer, decksCard, Logs.removeFromDeck);
                onlinePlayer.getDecks().get(hero.getName()).remove(decksCard);
                Contains = true;
                break;
            }
        }
        if (!Contains) {
            throw new MyException("You dont Have This in Your Deck");
        }
        if (onlinePlayer.getDecks().get(hero.getName()).isEmpty()) {
            throw new MyException("You dont Have Any Card in Your Deck");
        }
    }
}
