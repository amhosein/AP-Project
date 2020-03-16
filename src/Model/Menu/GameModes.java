package Model.Menu;

public class GameModes extends Menu {
    private static GameModes gameModes;

    public static GameModes getGameModes() {
        if (gameModes == null)
            gameModes = new GameModes("Game Mode");
        return gameModes;
    }

    public GameModes(String name) {
        super(name);
    }
}
