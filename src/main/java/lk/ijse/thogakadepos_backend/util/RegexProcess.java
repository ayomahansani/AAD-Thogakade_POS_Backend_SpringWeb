package lk.ijse.thogakadepos_backend.util;

import java.util.regex.Pattern;

public class RegexProcess {

    public static boolean customerIdMatcher(String customerId){
        String regexForCustomerId = "^C\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForCustomerId);
        return regexPattern.matcher(customerId).matches();
    }

    public static boolean itemCodeMatcher(String itemCode){
        String regexForItemCode = "^I\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForItemCode);
        return regexPattern.matcher(itemCode).matches();
    }

    public static boolean orderIdMatcher(String orderId){
        String regexForOrderId = "^O\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForOrderId);
        return regexPattern.matcher(orderId).matches();
    }

}
