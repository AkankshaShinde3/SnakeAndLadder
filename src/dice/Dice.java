package dice;
public class Dice {
    
    int min = 1;
    int max = 6;

    public int  rollDice()
    {
        double ans = (Math.random() * (max)) + min; //max min becoz we are giving it the range from where we have to start
        return (int)ans;
    }
}