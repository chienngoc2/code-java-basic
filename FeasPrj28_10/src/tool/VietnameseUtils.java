/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;


import java.text.Normalizer;
import java.util.regex.Pattern;

public class VietnameseUtils {
    public static String removeDiacritics(String str) {
        if (str == null) {
            return null;
        }
        // Chuẩn hóa chuỗi thành dạng NFD (tách dấu)
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        // Loại bỏ các dấu kết hợp (diacritics)
        String withoutDiacritics = normalized.replaceAll("\\p{M}", "");
        // Thay thế đ và Đ thành d và D
        return withoutDiacritics.replace("đ", "d").replace("Đ", "D");
    }
}

