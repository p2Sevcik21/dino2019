
/**
 * Abstract class Dinosaur - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private int age;
    private String type;
    private String gender;
    private int wins;
    private int battleCount;
    private int health; // 0 - dead, 100 - perfect health
    private int power;
    private int defense;
    private boolean isAlive;
    
    /**
     * Dinosaur Constructor -- There is no default constructor because we want
     * to be able to have many kinds of dinosaurs ~ if we had a predetermined
     * constructor, then every dinisoaur would be the same, which wouldn't
     * allow for variations like Trexes and Pterodactyls
     */
    public Dinosaur(String t, int p)
    {
        this.type = t;
        this.age = 0;
        this.wins = 0;
        this.health = 25;
        this.battleCount = 0;
        this.isAlive = true;
        if (Math.random() < 0.5)
        {
            this.gender = "M";
        }
        else 
        {
            this.gender = "F";
        }
        this.power = p;
        // I hate dinosaurs lol
    }
    /********************GETTERS**********************
     */
    //Welcome to the world of Getting variables
    public String getType()
    {
        return this.type;
    }
    public int getAge()
    {
        return this.age;
    }
    public int getWins()
    {
        return this.wins;
    }
    public int getHealth()
    {
        return this.health;
    }
    public int getBattleCount()
    {
        return this.battleCount;
    }
    public String getGender()
    {
        return this.gender;
    }
    public int getPower()
    {
        return this.power;
    }
    public boolean getIsAlive()
    {
        return this.isAlive;
    }
    /**********************SETTERS***********************
     */
    //And now we enter the world of Setting variables
    public void setAge(int amt)
    {
        this.age = amt;
    }
    public void setWins(int amt)
    {
        this.wins = amt;
    }
    public void setHealth(int amt)
    {
        this.health = amt;
    }
    public void setBattleCount(int amt)
    {
        this.battleCount = amt;
    }
    public void setGender(String nGender)
    {
        this.gender = nGender;
    }
    public void setType(String nType)
    {
        this.type = nType;
    }
    public void setIsAlive(boolean b)
    {
        this.isAlive = b;
    }
    /*******************METHODS************************
     */
    /**
     * Attack is abstract because the attack method must be different for every
     * type of dino ~ We don't want top predators like Trexs to have the same
     * chance of winning as something like a stegosaurus. That wouldn't be
     * any fun!
     */
    public abstract boolean attack(Dinosaur def);
    //Future programmers will have to define this method ~ Generic method
    
    public void ageUp()
    {
        this.age++;
        if (this.age > 25)
        {
            this.health = this.health - (int)(Math.random()*8);
        }
        else if (this.age < 10)
        {
            this.health+=10;
        }
        else {
            this.health+=3;
        }
        
        this.checkHealth();
        
    }
    
    public void checkHealth()
    {
        if (this.health <= 0)
        {
            this.health = 0;
            if(this.isAlive==true)
            {
                System.out.println("\t" + this.toString()+ " just died!");
            }
            this.isAlive = false;
        }
        else if (this.health > 100)
        {
            this.health = 100;
        }
    }
    
    public void update(boolean winner, Dinosaur def)
    {
        this.battleCount++; 
        def.setBattleCount(def.getBattleCount()+1);
        if (winner == true)
        {
            this.wins++;
            def.setHealth(def.getHealth() - this.power);
            def.checkHealth();
        }
        else{
            def.setWins(def.getWins() + 1);
            this.health -= def.getPower();
            this.checkHealth();
        }
    }
    
    public String toString()
    {
        return this.type + " Age:" + this.age + " Health:" + this.health
        + " " + this.gender +  " W-L:" + this.wins + "-" +
        (this.battleCount-this.wins);
    }
    
}
