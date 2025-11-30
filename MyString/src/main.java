/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringProcess str = new StringProcess();
        String toUpperCase = str.toUpperCaseString("Hello");
        System.out.println(toUpperCase);
        String toLowerCase = str.toLowerCaseString("Hello");
        System.out.println(toLowerCase);
        String toUpperTheFirstCharacter = str.toUpperTheFirstCharacter("hello, world!");
        System.out.println(toUpperTheFirstCharacter);
        String s = "Hello";
        // hàm substring(a,n...) lấy từ giá trị a đến giá trị n-1
        String s1 = s.substring(1, 3);
        System.out.println(s1);

        boolean isEqual = str.checkTwoStringIsEqual("Hello, World!", "Hello1 World!");
        System.out.println("result: " + isEqual);

        boolean isEqualIgnoreCase = str.checkTwoStringIsEqualIgnoreCase("Hello, World!", "hello, world!");
        System.out.println("result: " + isEqualIgnoreCase);
        boolean isContains = str.checkContains("Hello", "World");
        System.out.println("result: " + isContains);

        boolean isStartWith = str.checkStartWith("Hello, World!", "Hello");
        System.out.println("result: " + isStartWith);

        boolean isEndWith = str.checkEndWith("Hello, World!", "World!");
        System.out.println("result: " + isEndWith);

        String relaceString = str.relaceString("Java Hello, World!", "Hello", "Hi");
        System.out.println(relaceString);

        String removeSpaceAtBeginAndEnd = str.removeSpaceAtBeginAndEnd(" Hello, World! ");
        System.out.println(removeSpaceAtBeginAndEnd);

        String formatANumber2 = str.formatANumberWithTwoDecimalPlaces(3.14159);
        System.out.println(formatANumber2);

        String formatANumber3 = str.formatANumberWithTwoDecimalNotRound(3.164159);
        System.out.println(formatANumber3);

        char charAt = str.getACharacterAtIndex("Hello, World!", 1);
        System.out.println(charAt);

        int countDigit = str.countDigitInAString("Hello 34, World! 123");
        System.out.println(countDigit);

        int countLetter = str.countLetterInAString("Hello 34, World! 123");
        System.out.println(countLetter);

        int countSpecial = str.countSpecialCharacterInAString("Hello 79$, World! 123");
        System.out.println(countSpecial);

        String reverseString = str.reverseString("Hello, World!");
        System.out.println(reverseString);

        String upperCaseWord = str.upperCaseFirstLetterOfEachWord("hello world");
        System.out.println(upperCaseWord);

    }

}
