
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class DinoDriver1
     */
    public static void main(String[] args)
    {
        //Dinosaur d1 = new Dinosaur("Dino");

        Trex t1 = new Trex();

        Trex t2 = new Trex();

        Stego s1 = new Stego();

        Triceratops tr1 = new Triceratops();

        t1.setHealth(100);
        s1.setHealth(100);
        
        t2.setHealth(100);
        tr1.setHealth(100);
        int suc = 0;
        for(int i=0; i<100; i++)
        {
            
            if (tr1.getIsAlive() == true && t1.getIsAlive() == true)
            {
                // t2.ageUp();
                // t1.ageUp();
                // System.out.println(t1.toString());
                // System.out.println(t2.toString());
                if (tr1.attack(t1))
                {
                    suc++;
                }

                System.out.println(t1.toString()+"  ~~~  "+s1.toString());
            }
        }
        System.out.println(suc);
    }
}
