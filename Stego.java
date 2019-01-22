
/**
 * Write a description of class Stego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stego extends Dinosaur
{
    public Stego()
    {
        // initialise instance variables
        super("Stego", 20);
    }
    
    public boolean attack(Dinosaur def)
    {
        if (def.getIsAlive() == true)
        {
        double prob = 0.0;
        if (def.getType().equals("Trex"))
        {
            prob = 0.4;
        }
        else if (def.getType().equals("Stego"))
        {
            prob = 0.6;
        }
        else if (def.getType().equals("Triceratops"))
        {
            prob = 0.7;
        }
        else {
            prob = 0.8;
        }
        if (Math.random() < prob)
        {
            this.update(true, def);
            return true;
        }
        else
        {
            this.update(false, def);
            return false;
        }
        }
        else{
            return true;
        }
    }
}
