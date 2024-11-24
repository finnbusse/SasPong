import sas.*;

public class Game {
    public static void main(String[] args) {
        new Game();
    }


    View window;
    Rectangle player1, player2;
    Circle ball;
    Text scoreText;

    double speed, direction;
    int score;
    Boolean gameOver;

    public Game() {

        window = new View(700, 500, "Pong");

        player1 = new Rectangle(50, 150, 20, 200);
        player2 = new Rectangle(630, 150, 20, 200);

        ball = new Circle(340, 240, 10);

        speed = 1;
        direction = 90;
        score = 0;

        gameOver = false;

        scoreText = new Text(250, 50, "Punkte " + score);

        startGame();
    }

    public void startGame(){

        while(!gameOver) {

            ball.move(speed);
            window.wait(1);

            if (ball.intersects(player2)) {
                speed = -speed;
                ball.move(speed);
                direction = 90;
                direction = direction + Tools.randomNumber(-10, 10);
                ball.setDirection(direction);
                score = score + 1;
                scoreText.setText("Punkte " + score);
            }

            if (ball.intersects(player1)) {
                speed = -speed;
                ball.move(speed);
                direction = 90;
                direction = direction + Tools.randomNumber(-10, 10);
                ball.setDirection(direction);
                score = score + 1;
                scoreText.setText("Punkte " + score);
            }

            if (window.keyUpPressed()) {
                player2.move(0,-1);
            }

            if (window.keyDownPressed()) {
                player2.move(0, 1);
            }

            if (window.keyPressed('w')) {
                player1.move(0, -1);
            }

            if (window.keyPressed('s')) {
                player1.move(0, 1);
            }

            if (ball.getCenterX() > 700 || ball.getCenterY() > 500 || ball.getCenterX() < 0 || ball.getCenterY() < 0) {
                new Text(20,20, "Game Over");
                gameOver = true;
            }
        }

    }
}
