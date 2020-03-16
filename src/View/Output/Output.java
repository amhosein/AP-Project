package View.Output;

public enum Output {
    welCome("Welcome to HeathStone! \n"),
    getUserName("Username:"),
    getPassword("Password:"),
    SuccessFullSingUp("You Signed Up SuccessFully! \n\n"),
    SuccessFullLogin("You Logged in SuccessFully! \n\n");

    private String Massage;

    Output(String Massage) {
        this.Massage = Massage;
    }

    public String getMassage() {
        return Massage;
    }
}
