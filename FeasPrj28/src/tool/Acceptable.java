
package tool;


public interface Acceptable {
    public final String CUS_CODE_VALID = "^(C|G|K)\\d{4}";
    public final String NAME_VALID = "^[a-zA-Z\\s]{2,25}$";
    public final String VINA_VALID ="^(081|082|083|084|085|088|091|094)\\d{7}";
    public final String VIETTEL_VALID ="^(032|033|034|035|036|037|038|039|086|096|097|098)\\d{7}";
    public final String MOBI_VALID ="^(070|079|077|076|078|089|090|093)\\d{7}";
    public final String VIETNAMEMOBI_VALID ="^(056|058|052|092)\\d{7}";
    public final String EMAIL_VAlID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public final String INTEGER_VALID = "\\d+";
    public final String FEAST_CODE = "PW001|PW002|PW003|PW004|PW005|PW006";
    
    public static boolean isValid(String data,String pattern){
        return data.matches(pattern);
    }
}