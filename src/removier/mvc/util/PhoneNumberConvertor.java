package removier.mvc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 01012345678 문자열을 010-1234-5678 형식으로 변환한다.
 */
public class PhoneNumberConvertor {
    public static final String PHONE_NUMBER_REGEX = "^010\\d{4}\\d{4}$";
    private static final Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);

    public static String convert(String phoneNumber) {
        if (!supports(phoneNumber)) {
            throw new IllegalArgumentException("지원하지 않는 번호입니다.");
        }

        String result = "";

        result = phoneNumber.substring(0, 3) + "-";
        result += phoneNumber.substring(3, 7) + "-";
        result += phoneNumber.substring(7, 11);

        return result;
    }

    public static boolean supports(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);

        boolean result = matcher.matches();

        if (!result) {
            System.out.println(phoneNumber + "은(는) 올바르지 않는 휴대폰 번호입니다.");
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(supports("01012345678"));
        System.out.println(supports("51012345678"));
    }
}
