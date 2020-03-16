package Model.Menu;

public class Profile extends Menu {
    private static Profile profile;

    public static Profile getProfile() {
        if (profile == null)
            profile = new Profile("Your Profile");
        return profile;
    }

    public Profile(String name) {
        super(name);
        setOrders("1.Delete Account");
        setOrders("2.Back");
    }
}
