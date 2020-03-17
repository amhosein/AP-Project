package Model.Menu;

public class Play extends Menu {
    private static Play play;

    public static Play getPlay() {
        if (play == null)
            play = new Play("Play Menu");
        return play;
    }

    public Play(String name) {
        super(name);
        setOrders("1.Game Mods");
        setOrders("2.Back");
    }
}
