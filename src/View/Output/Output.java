package View.Output;

public enum Output {
    welCome("Welcome to HeathStone! " +
            "Sign in / Sign up ?" +
            ""),
    getUserName("Username:"),
    getPassword("Password:")
    ;
    private String Massage;

    Output(String Massage) {
        this.Massage = Massage;
    }

    public String getMassage() {
        return Massage;
    }
}
