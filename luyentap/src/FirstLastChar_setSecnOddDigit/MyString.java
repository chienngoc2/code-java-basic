/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstLastChar_setSecnOddDigit;

/**
 *
 * @author ADMIN
 */
class MyString implements IString {

    @Override
    public int f1(String str) {
        String[] arr = str.split(" ");
        int count = 0;
        for (String word : arr) {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            if (Character.isLetter(first) && Character.isLetter(last)) {
                boolean flag = true;
                for (int i = 1; i < word.length() - 1; i++) {
                    if (!Character.isDigit(word.charAt(i))) {
                        flag = false;
                        break;

                    }
                }
                if (flag) {
                    count++;
                }
            }
        }

        return count;

    }

    @Override
    public String f2(String str) {
        StringBuilder result = new StringBuilder(str);
        StringBuilder oddD = new StringBuilder();
        char first = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) && c -'0' % 2 !=0 ) {
                if(oddD.indexOf(String.valueOf(c))== -1){
                    oddD.append(c);
                }
                else {
                    result.setCharAt(i, first);
                }
            }
        }
        return result.toString();
    }

}
