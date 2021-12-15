import java.util.Random;

public class Randomizer {

    Random rand = new Random();         //creates random object - used to determine which player goes first
    int randomNumber;

    //returns boolean on fifty fifty chance
    public boolean fiftyFiftyChance(){

        //return true if random number is even
        return randomBetween0andX(2) == 0;

    }

    //returns number between 0 and Input Arg
    public int randomBetween0andX(int chance){

        //generate a random number
        randomNumber = rand.nextInt();

        //ensure random number is positive
        //which ensures modulo is always positive
        if(randomNumber < 0){
            randomNumber = randomNumber * -1;
        }

        //returns number between 0 and chance
        return randomNumber % chance;

    }

}
