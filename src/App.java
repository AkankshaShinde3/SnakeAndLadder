import java.util.Scanner;
import java.util.HashMap;
import board.Board;
import player.Player;
import dice.Dice;
import game.Game;
import jumper.Jumper;
import coordinates.Coordinates;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        HashMap<String, Jumper> map = new HashMap<>();

        //creatinf where would be snake and laddder using hashmap
        map.put("6", new Jumper(new Coordinates(5, 5), new Coordinates(6,6)));
        map.put("97", new Jumper(new Coordinates(0,1), new Coordinates(9,9)));
        map.put("21", new Jumper(new Coordinates(7,0), new Coordinates(0,9)));
        map.put("64", new Jumper(new Coordinates(3,3), new Coordinates(7,4)));


        // Player p1 = new Player();
        // p1.setInfo("doraemon", "doraemon@gmail.com", 19, 12345, "panvel");
        // p1.getInfo();

        // System.out.println();

        // Player p2 = new Player();
        // p2.setInfo("nobita", "nobita@gmail.com", 20, 67931, "matheran road");
        // p2.getInfo();

        Player p1 = new Player();
        p1.setPlayerDetailsFromUserInput(p1);
        Player p2 = new Player();
        p2.setPlayerDetailsFromUserInput(p2);


        // Dice myDice = new Dice()1;
        // System.out.println(myDice.rollDice(1, 6));

        // Coordinates cord = new Coordinates(3, 1);
        // cord.printCoordinates();

        // Coordinates one = new Coordinates(5, 3);
        // Coordinates two = new Coordinates(1, 3);

        // Jumper jump = new Jumper(one, two);
        // System.out.println(jump.getJumperInfo());

        Board b = new Board(10, map);
        b.printBoard();

        Game game = new Game(b, new Player[] {p1, p2}, new Dice());
        game.Play();
        
        sc.close(); 
    }
}
  