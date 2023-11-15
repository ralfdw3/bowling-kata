package bowling;

public class Main {
    public static void main(String[] args) {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 30; i++) {
            bowling.execute();
        }
    }
}