
/**
 * Write a description of class DinoDriver3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;

public class DinoDriver3
{
    public static void main(String[] args)
    {
        ArrayList<Dinosaur> dinos = new ArrayList<Dinosaur>();
        System.out.print("How many Dinosaurs: ");
        Scanner scan = new Scanner(System.in);
        int popSize = scan.nextInt();
        int rando = 0;
        int trexNum = 0;
        int triNum = 0;
        int steNum = 0;
        for (int i = 0; i <popSize; i++)
        {   
            rando = (int)(Math.random()*3); //Change if more dinos added
            if (rando == 0){
                dinos.add(new Trex());
                trexNum++;
            }
            if (rando == 1){
                dinos.add(new Triceratops());
                triNum++;
            }
            if (rando == 2){
                dinos.add(new Stego());
                steNum++;
            }
        }
        int deadCount = 0;
        for (Dinosaur d : dinos) // for each loop
        {
            rando = (int)(Math.random()*50);
            for (int j = 0; j<rando; j++)
            {
                d.ageUp();
            }

            if (d.getIsAlive() == false)
            {
                deadCount++;
            }
            // System.out.println(d.toString());
        }
        
        DinoDriver3.removeDeadDinos(dinos);
        
        int winCount = 0; 
        int battleCount = 0;
        int dead = 0;
        int newdead = 0;
        int round = 0;
        int matingPop = 0;
        while (dinos.size() > 1)
        {
            round++;
            matingPop = 0;
            for (Dinosaur d : dinos) 
            {
                d.ageUp();
            }

            for (Dinosaur d : dinos) 
            {
                if(d.getIsAlive() && dinos.size()>1){ //Is true
                    Dinosaur defend = dinos.get(getDefender(dinos, d));
                    battleCount++;
                    if(d.attack(defend)){
                        winCount++;
                    }
                }
                if (DinoDriver3.matable(d) == true)
                {
                    matingPop++;
                }
            }
            DinoDriver3.removeDeadDinos(dinos);
            
            System.out.println(DinoDriver3.danceCard(dinos));
            
            
            System.out.println("\n_Round_" + round + "_Results_ \nLiving: " + 
            dinos.size() + "\nBattles: " + battleCount 
            + "\nWins: " + winCount + "\nDead this round: " + newdead 
            + "\nTotal Dead: " + dead + "\nMating Population: " + matingPop);
        }
        System.out.println("Winner: " + dinos.get(0));
    }
    public static void removeDeadDinos( ArrayList<Dinosaur> p )
    {
        for(int i =0; i<p.size(); i++)
            if(p.get(i).getIsAlive() == false)
            {
                p.remove(i);
                i--;                   
            }
        }
    public static ArrayList danceCard( ArrayList<Dinosaur> p )
    {
        ArrayList<Dinosaur> temp = p;
        ArrayList<Dinosaur> suitors = new ArrayList<Dinosaur>();
        int dinoloc = 0;
        int rand = (int)(p.size() * 0.1);
        for (int i = 0; i <= rand; i++)
        {
            dinoloc = ((int)((Math.random()*temp.size())));
            suitors.add(temp.get(dinoloc));
            temp.remove(dinoloc);
        }
        return suitors;
    }
    public static boolean weddingBells( ArrayList<Dinosaur> p, Dinosaur d )
    {
        boolean yes = false;
        
        return yes;
    }
    public static boolean matable(Dinosaur z)
    {
        if ((z.getHealth() > 20) && (7 < z.getAge()) && (32 > z.getAge())) {
        return true;}
        else{
        return false;}
    }
    public static int livingDinos(ArrayList <Dinosaur> q)
    {
        int l = 0; //Number of alive dinos
        for (Dinosaur d: q)
        {
            if(d.getIsAlive()){
                l++;
            }
            else {
                q.remove(d);
            }
        }
        return l;
    }
    public static int getDefender(ArrayList <Dinosaur> p, Dinosaur att)
    {
        Dinosaur def; //Not initialized - doesn't need to be
        int rand = 0;
        do
        {
            rand = (int)(Math.random()*p.size());
            def = p.get(rand);
        }while(def == att || !def.getIsAlive()); // or != true or == false
        return rand;
    }
}











/*     
     *                                   
     *                                        
     *                  _-^-_                
     *                                          
     *                                        ___________       
     *                                         @ @ @ @ @    
     *                                        -----------        
     *                             
     *
     *
     *
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
     *                                     
     *                ###                 
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
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *           
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *   
     *  
     *   
     */

