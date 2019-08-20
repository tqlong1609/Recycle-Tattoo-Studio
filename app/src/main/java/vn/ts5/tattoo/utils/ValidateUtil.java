package vn.ts5.tattoo.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class ValidateUtil {
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
