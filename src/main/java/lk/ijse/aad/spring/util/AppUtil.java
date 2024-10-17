package lk.ijse.aad.spring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerID(){
        return "C-"+ UUID.randomUUID();
    }

    public static String generateItemID(){
        return "I-"+ UUID.randomUUID();
    }

    public static String generateOrderID(){
        return "ORDER-"+ UUID.randomUUID();
    }

    public static String generateOrderDetailsId(){
        return "DETAILS-" + UUID.randomUUID();
    }
}
