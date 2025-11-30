
package q4luyentap;

import java.util.Scanner;


public class Q4Luyentap {

   
    public static void main(String[] args) {
        
        System.out.println("1. Test countWords");
        System.out.println("2. Test sumOfEvenNumberInString");
        System.out.println("3. Test isPerfect");
        System.out.println("4. Test countPalindromeWords");
        System.out.println("5. Test convertToTitleCase");
        System.out.println("Please enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        MyProcessor processor = new MyProcessor();
        switch (choice) {
            case 1:
                System.out.println("Please enter a sentence: ");
                String sentence = scanner.nextLine();
                int count = processor.countWords(sentence);
                System.out.println("OUTPUT:");
                System.out.println(count);
                break;
            case 2:
                System.out.println("Please enter a string of numbers separated by space: ");
                String input = scanner.nextLine();
                int sum = processor.sumOfEvenNumberInString(input);
                System.out.println("OUTPUT:");
                System.out.println(sum);
                break;
            case 3:
                System.out.println("Please enter a number: ");
                int number = scanner.nextInt();
                boolean isPerfect = processor.isPerfect(number);
                System.out.println("OUTPUT:");
                System.out.println(isPerfect);
                break;
            case 4:
                System.out.println("Please enter a sentence: ");
                String sentence2 = scanner.nextLine();
                int count2 = processor.countPalindromeWords(sentence2);
                System.out.println("OUTPUT:");
                System.out.println(count2);
                break;
            case 5:
                System.out.println("Please enter a sentence: ");
                String input2 = scanner.nextLine();
                String titleCase = processor.convertToTitleCase(input2);
                System.out.println("OUTPUT:");
                System.out.println(titleCase);
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
    }
    

