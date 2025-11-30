
package q4luyentap;


public interface Processor {
    int countWords(String sentence);//function to count the number of words in a sentence
    int sumOfEvenNumberInString(String input);//function to sum all the even numbers in a string
    boolean isPerfect(int number);
    int countPalindromeWords(String sentence);//function to count the number of palindrome words in a sentence
    String  convertToTitleCase(String input);//function to convert a string input from the keyboard into lowercase and then capitalize the first letter of each words
}
