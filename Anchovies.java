import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Anchovies will print out every variation of the word "anchovies".
 *
 * @author Randall
 * @version 0.1
 */
public class Anchovies
{
    //To get the number of all possible arrangements we can use the permutation formula
    // Let n = the number of letters in the string
    // We can get the total amount of permutations by doing n! (n factorial)
    
    public static void main(String[] args){
        // Put whatever you want to get all permutations for in str
        String str = "anchovies";
        
        // Lets test the word we are going to work with 
        if(str.length() == 0){ // Enter nothing in str, get this message 
            System.out.println("You have not chosen a word...Please try again");
        }
        else{ // Enter a valid string, yayy! Time to start formulating 
            try { // We need to add this because during run-time, the program may encounter an error and crash it, we dont want that
                // Creates a txt file that will be written over to
                FileWriter deliveryMan = new FileWriter("anchoviesPermutations.txt");
                
                // Instantiating a buffer to help our deliveryMan from going back and forth everytime he needs to bring a package
                BufferedWriter postalOffice = new BufferedWriter(deliveryMan);  
                
                // Start appending those permutations to the "anchoviesPermutations.txt" file
                getPermutations(str, "", postalOffice); // When you get a permutation, ship it to the postalOffice to be delivered
                
                // Close the FileWriter, the postalOffice is closed, there is nothing else to deliver, good job deliveryMan
                postalOffice.close();
                
            } catch (IOException e){ // If there is an error, do this
                System.out.println("There was an error that occured during runtime");
            }

        }
        
    }
    
    public static void getPermutations(String str, String ans, BufferedWriter postalOffice){
        // We are dealing with recursion, there MUST be a base case
        // Once str becomes empty, lets print out all permutations for the string
        if(str.length() == 0){
            try{
                postalOffice.write(ans); // Write that permutation into the buffer
                postalOffice.newLine(); // Create a new line for *aesthetic* we want it to look pretty
            }
            catch (IOException e){
                System.out.println("Uh oh...there was an error during runtime");        
            }
            return; // Lets get out of here we are done
        }
        
        for(int i = 0; i < str.length(); i++){
            char ltr = str.charAt(i); // Take the initial character from the string
            String rest = str.substring(0, i) + str.substring(i + 1); // Get all of the characters remaining (excluding the one thats stored in ltr)
            
            getPermutations(rest, ans + ltr, postalOffice); // Call her again, but this time, with ones we just shoved in rest
        }
    }
    
}
