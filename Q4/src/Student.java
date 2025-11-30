
public class Student {
    public static boolean matchId(String id){
        String[] arr = id.split("\\s+");
        for(String i: arr){
            if (i.length()< 6 ||i.length() >8) {
                return false;
            }
        }
        String sb  = id.substring(0,2);
        if (!sb.equalsIgnoreCase("se") && !sb.equalsIgnoreCase("he")&& !sb.equalsIgnoreCase("qe")) {
            return false;
        }
        if (!id.substring(2).matches("\\d{4,6}")){
            return false;
        };
        return true;
    }
    
    public static String formatCamel(String str){
        String result =str.replaceAll("[^a-zA-Z]","");
        return result;
    }
}
