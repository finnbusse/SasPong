import sas.*;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    View homeScreen;
    Text header, pressAnyButton;

    public Main() {

        homeScreen = new View(700, 500, "Pong");

        header = new Text(320, 100, "Pong");
        pressAnyButton = new Text(200, 300, "Press any button to start...");

        while(true){

            if (homeScreen.keyPressed()) {
                new Game();
            }

            homeScreen.wait(1);
        }
    }
}
