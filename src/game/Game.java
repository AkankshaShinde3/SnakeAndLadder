package game;

import board.Board;
import coordinates.Coordinates;
import player.Player;
import dice.Dice;
import jumper.Jumper;

public class Game {
    
    Board board; //this is class and it object i.e (class object;)
    Player players[]; // to store the number of players
    Dice dice; 
    int turn;
    Coordinates[] places; //for starting position of players
    boolean isAllowed[];

    public Game(Board board, Player players[], Dice dice){

        this.board = board;
        this.players = players;
        this.dice = dice;
        turn = 0;
        places = new Coordinates[players.length];
        isAllowed = new boolean[players.length];

        // To declare the starting position of all the players
        for(int i=0; i<players.length; i++)
        {
            places[i] = new Coordinates(board.getBoardSize() - 1, 0);
        }
    }

        public void Play()
        {
            //using while loop as we dont know when the players are going to reach the final end
            while(true)
            {
                int num = dice.rollDice();
                System.out.println(players[turn].getPlayerName() + " rolled -> " + num + " [" + places[turn].getRow() + "," + places[turn].getCol() + "]");

                if(! isAllowed[turn])
                {
                    if(num != 1) //if num is not equal to 1(if you get 1 then only you can begin the juorney to end) then it is the tuen of other player
                    {
                        turn = 1 - turn;
                        continue;
                    }
                    else
                    {
                        isAllowed[turn] = true; 
                    }
                }

                Coordinates newCoordinate = getnewCoordinates(places[turn], num); //we pass here the current position of player and the dice value which she got.   
                //check if we have reached the destination or not        
                if(newCoordinate.getRow() < 0)
                {
                    System.out.println(players[turn].getPlayerName() + " has WON !!!");
                    return;
                }

                places[turn] = newCoordinate;
                turn = 1 - turn;
            }
        
        }

        private Coordinates getnewCoordinates(Coordinates oldCoordinates, int num)
        {
                int row = oldCoordinates.getRow();
                int col = oldCoordinates.getCol();

                while(num > 0)
                {
                    if(row % 2 != 0) //for odd row
                    {
                        if(col == board.getBoardSize()-1)
                        {
                            row--;
                        }
                        else
                        {
                            col++;
                        }
                    }
                    else
                    {
                        if(col == 0)
                        {
                            row--;
                        }
                        else
                        {
                            col--;
                        }
                    }

                    num--;
                }

                if(row < 0 ) return new Coordinates(row, col);

                if(checkIfJumperExists(row, col))
                {
                    Jumper jumper = board.jumpers.get(board.board[row][col]);
                    return jumper.end;
                }

                return new Coordinates(row, col);
    }
    
    private boolean checkIfJumperExists(int row, int col)
    {
        return board.jumpers.containsKey(board.board[row][col]);
    }
}


