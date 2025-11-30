/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumtoString;

/**
 *
 * @author ADMIN
 */
public class MyUtiliteles implements IUtiliteles{

    @Override
    public int reverseNumber(int n) {
        String str = n + "";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    @Override
    public int countSpecialCharacter(String s) {
        int count = 0;
        for (int i = 0;i < s.length() ; i++) {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            count +=1;
            
        }
        return count;
    }
    
}
