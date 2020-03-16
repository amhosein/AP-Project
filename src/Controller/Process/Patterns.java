package Controller.Process;

import java.util.regex.Pattern;

public class Patterns {
    Pattern signUp = Pattern.compile("sign up");
    Pattern signIn = Pattern.compile("sign in");
    Pattern logout = Pattern.compile("logout");
    Pattern forceStop = Pattern.compile("force stop");
    Pattern playMenu = Pattern.compile("play");
    Pattern cardsCollection = Pattern.compile("cards collection");
    Pattern shop = Pattern.compile("shop");
    Pattern profile = Pattern.compile("profile");
    Pattern allHeroes = Pattern.compile("all heroes");
    Pattern allCards = Pattern.compile("all cards");
    Pattern selectHero = Pattern.compile("select hero");
    Pattern addCard = Pattern.compile("add card");
    Pattern removeCard = Pattern.compile("remove card");
    Pattern deck = Pattern.compile("deck");
    Pattern back = Pattern.compile("back");
    Pattern deleteAccount = Pattern.compile("delete account");
    Pattern Buy = Pattern.compile("buy");
    Pattern Sell = Pattern.compile("sell");
}
