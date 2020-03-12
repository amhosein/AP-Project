package View.Output;

public class Print {
    public Print(String massage){
       System.out.println(massage);
    }
    public Print(Output output){
       System.out.print(output.getMassage());
    }
}
