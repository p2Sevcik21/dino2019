import java.util.Scanner;
/**
 * Write a description of class DinoDriverDos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriverDos
{
    // instance variables - replace the example below with your own
    public static void main(String[] args)
    {
        //Scans for number of Dinosaurs
        Scanner s = new Scanner(System.in);
        String num = "";
        System.out.println("How many dinos?");
        num = s.nextLine();
        Integer td = Integer.valueOf(num); //Total Dinosaurs, shorthanded as td
        
        Dinosaur[] pop = new Dinosaur[td];
        int rando = 0;
        int trexNum = 0;
        int triNum = 0;
        int steNum = 0;
        for (int i = 0; i <td; i++)
        {   
            rando = (int)(Math.random()*3); //Change if more dinos added
            if (rando == 0){
                pop[i] = new Trex();
                trexNum++;
            }
            if (rando == 1){
                pop[i] = new Triceratops();
                triNum++;
            }
            if (rando == 2){
                pop[i] = new Stego();
                steNum++;
            }
        }
        System.out.println("Trexs: " + trexNum + " Triceratops: " + triNum 
        + " Stegosaurus: " + steNum );

        int deadCount = 0;
        int rand = 0;
        for (Dinosaur d : pop) // for each loop
        {
            rand = (int)(Math.random()*50);
            for (int j = 0; j<rand; j++)
            {
                d.ageUp();
            }

            if (d.getIsAlive() == false)
            {
                deadCount++;
            }
        }

        //----------------------Prep Work Ends Here--------------------------

        int winCount = 0; 
        int battleCount = 0;
        int dead = 0;
        int newdead = 0;
        int round = 0;
        while (livingDinos(pop) > 1)
        {
            round++;
            for (Dinosaur d : pop) 
            {
                d.ageUp();
            }

            for (Dinosaur d : pop) 
            {
                if(d.getIsAlive() && livingDinos(pop)>1){ //Is true
                    Dinosaur defend = getDefender(pop, d);
                    battleCount++;
                    if(d.attack(defend)){
                        winCount++;
                    }
                }
            }
            newdead = (pop.length - DinoDriverDos.livingDinos(pop)) - dead;
            dead = (pop.length - DinoDriverDos.livingDinos(pop));
            // This is the system out. Get Ready
            System.out.println("\n_Round_" + round + "_Results_ \nLiving: " + 
            DinoDriverDos.livingDinos(pop) + "\nBattles: " + battleCount 
            + "\nWins: " + winCount + "\nDead this round: " + newdead 
            + "\nTotal Dead: " + dead + "\n");
        }
        Dinosaur winner = null;
        for (Dinosaur d : pop) 
            {
                if(d.getIsAlive()){ //Is true
                    winner = d;
                }
            }
        System.out.println("\nAfter " + battleCount + " battles, " + winner + " is the king!");
    }

    public static int livingDinos(Dinosaur[] p)
    {
        int l = 0; //Number of alive dinos
        for (Dinosaur d : p)
        {
            if(d.getIsAlive()){
                l++;
            }
        }
        return l;
    }

    public static Dinosaur getDefender(Dinosaur[] p, Dinosaur att)
    {
        Dinosaur def; //Not initialized - doesn't need to be
        // while (def == att || def.getIsAlive() == false)
        // {
        // def = p[(int)(Math.random()*p.length)];
        // }
        do
        {
            def = p[(int)(Math.random()*p.length)];
        }while(def == att || !def.getIsAlive()); // or != true or == false
        return def;
    }

    // int[] nums = new int[10];

    // System.out.println(nums[0]);

    // for (int i = 0; i<nums.length; i++)
    // {
    // nums[i] = 10+i;
    // }
    // for (int i = 0; i<nums.length; i++)
    // {
    // System.out.println(nums[i]);
    // }
    // for (int answer : nums)
    // {
    // System.out.println(answer);
    // }


    /*     
     *                   ##########
     *                  ############
     *                   ##########                    
     *                                                
     *                  #######
     *                 #########
     *                  ######
     *               
     *                 ###                             
     *                #####                       
     *                 ###
     *                                      __   __
     *                ###                  /  \0/  \
     *                # 
     *               / \
     *               | |
     *               | |
     *       ________|_|_                             *****
     *      /            \                          *****@***
     *     /    ______    \                        **@********
     *    /    |______|    \                        *****@***
     *   /     |______|     \                         ***** @
     *   |                  |                          | |
     *   |                  |       o=========         | |
     *   |     _______      |      ooo=========        | |
     *   |     |     |      |     ooooo=========       | |
     *   |     | o   |      |    ooooooo=========      | |   
     *   |_____|_____|______|   ooooooooo=========  @  | | @
     *  
     *   
     */

        
}
