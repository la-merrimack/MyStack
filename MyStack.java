//package week5_final.MyStack;
// package week4.MyLinkedList;
import java.util.Stack; // updated from using LinkedList
import java.util.Collections;
import java.util.Scanner;

/**
 * This program reads a list of numbers from the scanned input and
 * saves them into a stack sorted (updated from LinkedList) from the smallest to the largest (ascending order).
 * This program is maintained and has been updated from storing the input into a linked list
 * to a stack.
 * This program also shows examples of code reuse such as using Stack and Collections.sort().
 * I also seperated the logic of reading the input and the actual stack method
 *
 * <p>Running the program:</p>
 * <ul>
 *   <li>Compiling: <code>javac MyStack.java</code></li>
 *   <li>Running: <code>java MyStack</code></li>
 *   <li>Generating Javadocs: <code>javadoc -d docs MyStack.java</code></li>
 * </ul>
 *
 * <p>Program features:</p>
 * <ol>
 *   <li>Read a list of integers from user input</li>
 *   <li>Will validates the user input to ensure it's an integer type</li>
 *   <li>Will sorts the numbers within the stack in ascending order</li>
 *   <li>Will print the sorted list to the terminal</li>
 * </ol>
 */
public class MyStack {
  /**
  * This method will reads a list of integer numbers from a user, input from
  * the terminal.
  * It will then store them in a Stack data structure, and sorts them in
  * asc order.
  *
  * @param args cmd line arguments. These weren't used.
  */
  public static void main(String[] args) {
      // Will handle creating a stack
      Stack<Integer> numbers = readNumbers();

      // Will sort the stack
      sortMyStack(numbers); //updated to sortMyStack from sortMyLinkedList

      // Print the stack to terminal
      System.out.println("Your sorted stack is the following: " + numbers);
  }

  /**
     * Handles reading the user input of integers from a terminal and store them
     * within a stack.
     *
     * @return stack.
     */
    public static Stack<Integer> readNumbers() {
      Scanner scanner = new Scanner(System.in);
      Stack<Integer> numbers_stack = new Stack<>();

      System.out.println("Enter list of numbers - (enter x to end list):");

      // Reading integer input from the user until they type "x"
      while (scanner.hasNext()) {
          String input = scanner.next();

          // Exit the loop if the input is "exit" or "x"
          if (input.equalsIgnoreCase("x") || input.equalsIgnoreCase("exit")) {
              break;
          }

         // Check if the input is a valid integer
            if (!checkIfValidInt(input)) {
             System.out.println("Invalid number, please only enter a number.");
             continue; // Prompt the user to enter again if the input is invalid
         }

         int number = Integer.parseInt(input);
         numbers_stack.push(number); // Add number to the Stack - updated from LinkedList
      }

      // Closing the scanner to prevent resource leak
      scanner.close();

      return numbers_stack;
  }

  /**
     * This method will sort a stack in ascending order.
     * As an explicit example code reuse, this method uses the sort method from
     * Collections as an alternative to writing a sorting method from scratch.
     *
     * @param numbers_stack The stack that will be sorted in ascending order.
     */
    public static void sortMyStack(Stack<Integer> numbers_stack) {
      // Reusing the Collections framework sort method to sort the list
      Collections.sort(numbers_stack);
  }

  /**
  * This method will validate if the input a user entered is a valid number.
  *
  * @param user_input the string to check if a valid number.
  */
  public static boolean checkIfValidInt(String user_input){
    // Iterate through each character of the user_input string
       for (char ch : user_input.toCharArray()) {
        // Check if any character is not a digit, if either is not a digit, will return false
        if (!Character.isDigit(ch)) {
            return false; // If any character is not a digit, return false
        }
    }
    // If all characters are integers, will return true.
    return true;
  }
}
