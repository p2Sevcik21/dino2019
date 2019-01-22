
/**
 * Write a description of class ArrayListTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTester
{
    public static void main(String[] args)
    {
        System.out.print("How many words: ");
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int numWords = scan.nextInt();
        System.out.println(numWords);
        
        ArrayList <String> words = new ArrayList<String>();
        words.add("This");
        words.add("is");
        words.add("not");
        words.add(0, "fun"); 
        words.add(0, "good");
        words.add(1, "sir");
        System.out.println(words);
        System.out.println(words.size());
        words.remove(1);
        System.out.println(words);
        System.out.print(words.size());
        
    }
}

























/*     
     *                                   _
     *                                  / 
     *                          _______/
     *
     *
     *
     *
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
     */

