package lk.ijse.thogakadepos_backend.util;

import java.util.UUID;

public class AppUtil {

    public static String generateTransactionId(){
        return "TRANSACTION-" + UUID.randomUUID();
    }
}
