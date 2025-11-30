/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerSqua_ReverseList_set;


import java.util.Collections;
import java.util.List;


public class MyWall implements IWall {

    @Override
    public int f1(List<Wall> t) {
       int min = Integer.MAX_VALUE;
       
       for(Wall w:t){
           int length = w.getPlace().length();
           if(isSquare(length) == 1 && length > 1){
               if(w.getArea() < min){
                   min = w.getArea();
               }
           }
       }
       return min;
            
        
    }
    private int isSquare(int n){
        int result = (int)Math.sqrt(n);
        if (result * result == n) {
            return 1;
        }
        return 0;
    }

    @Override
    public void f2(List<Wall> t) {
        Collections.reverse(t.subList(3, 6));
    }

    @Override
    public void f3(List<Wall> t) {
        Wall min = t.get(0);
        for(Wall w:t){
            if (w.getArea() < min.getArea()) {
                min = w;
            }
        }
         t.set(0, min);
    }
    
}
