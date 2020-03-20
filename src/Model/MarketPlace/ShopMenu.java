package Model.MarketPlace;

import Exeptions.MyException;
import Model.Cards.Card;
import Model.Cards.Hero;
import Model.Menu.Menu;
import Model.Primary;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShopMenu extends Menu {
    private static ShopMenu shopMenu;
    private Set<Card> CanBuy;

    public static ShopMenu getShopMenu() {
        if (shopMenu == null)
            shopMenu = new ShopMenu("Welcome to CardsMarket :)");
        return shopMenu;
    }

    public ShopMenu(String name) {
        super(name);
        setOrders("1.Buy");
        setOrders("2.Sell");
        setOrders("3.Can Buy");
        setOrders("4.Your Cards");
        setOrders("5.Back");
    }

    public void buyCards(Card card) {
        setCanBuy();
        try {
            if (onlinePlayer.getGold() < card.getCast())
                throw new MyException("Not Enough Gold ");
            if (onlinePlayer.getUnlockedCards().contains(card))
                throw new MyException("You have This Card");
            new Logger(onlinePlayer, card, Logs.buyCard);
            onlinePlayer.setGold(onlinePlayer.getGold() - card.getCast());
            onlinePlayer.addUnlockedCards(card);
        } catch (MyException e) {
            e.getMessage();
        }
    }

    public Set<Card> setCanBuy() {
        CanBuy = new HashSet<>();
        outer:
        for (Card card : Primary.allCards) {
            for (Card playerCard : onlinePlayer.getUnlockedCards()) {
                if (card.getName().equals(playerCard.getName())) {
                    continue outer;
                }
            }
            CanBuy.add(card);
        }
        return CanBuy;
    }

    public void SellCard(Card card) {
        try {
            if (!onlinePlayer.getUnlockedCards().contains(card))
                throw new MyException("You dont have this Card");
            new Logger(onlinePlayer, card, Logs.sellCard);
            onlinePlayer.setGold(onlinePlayer.getGold() + card.getCast());
            onlinePlayer.getUnlockedCards().remove(card);
            for (Hero hero : onlinePlayer.getUnlockedHeroes()) {
                onlinePlayer.getDecks().get(hero.getName()).remove(card);
            }
        } catch (MyException e) {
            e.getMessage();
        }
    }
}
