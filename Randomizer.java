import java.util.Random;

public class Randomizer {

    Random rand = new Random();         //creates random object - used to determine which player goes first
    int randomNumber;

    public Randomizer (){



    }

    public boolean fiftyFiftyChance(){

        return randomBetween0andX(2) == 0;

    }

    public int randomBetween0andX(int chance){

        randomNumber = rand.nextInt();

        if(randomNumber < 0){
            randomNumber = randomNumber * -1;
        }

        return randomNumber % chance;

    }

}
