package jumper;
import coordinates.Coordinates;

public class Jumper {
    
    Coordinates start;
    public Coordinates end;
    String name;

    public Jumper(Coordinates start, Coordinates end)
    {
        this.start = start;
        this.end = end;

        if(start.getRow() < end.getRow())
        {
            this.name = "snake";
        }
        else
        {
            this.name = "ladder";
        }
    }

    public String getJumperInfo()
    {
        return this.name;
    } 
}