 
public class main {

    public static void main(String[] args) {
        Integer n1 = new Integer("12");
        Integer n2 = new Integer("12");

        if (n1.equals(n2)) {
            System.out.println("bằng nhau");
        } else {
            System.out.println("ko bằng nhau");
        }
        String s1 = "abc";
        String s2 = new String("abc"); //nó đã tạo ra một địa chỉ mới
//String pool  

        if (s1 == s2) {     // việc so sánh này dựa trên địa chỉ
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
        // StringBuilder & StringBuffer
        // Stringbuffer is synchronized,StringBuilder is not Synchronied

        StringBuilder sb = new StringBuilder("abc");
        sb.append("def");
        String s = sb.toString();// dùng để trả về hàm String
        System.out.println(s);

        // insert a string at the specified index  
        sb.insert(1, "xyz");
        System.out.println(sb.toString());

// delete char at index  
        sb.deleteCharAt(1);
        System.out.println(sb.toString());

// delete a substring  
        sb.delete(1, 3);
        System.out.println(sb.toString());

// reverse a string
        sb.reverse();
        System.out.println(sb.toString());

// replace a subString
        System.out.println("before replace: " + sb.toString());
        System.out.println("after replace: " + sb.toString());

// set the length of the string builder to 0
        sb.setLength(0);
        System.out.println("length to 0: " + sb.toString());

// delete all the characters in the string builder
//        sb.delete(0, sb.length());

    }

}
