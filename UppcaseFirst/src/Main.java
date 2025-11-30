
public class Main {
   
    public static void main(String[] args) {
       String str = "chienngoc";
       System.out.println("CHuỗi ban đầu" + str);
       String firstChar = str.substring(0, 1);
       String conlai = str.substring(1,str.length());
       String strs = firstChar.toUpperCase();
       System.out.println("kết quả "+ (strs + conlai) );
              
    }
    
}
