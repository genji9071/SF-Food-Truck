package github.genji9071.sfFoodTruck.util;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseUtils {
    public static SfFoodTruckResponse success(Object result) {
        return new SfFoodTruckResponse(0, null, result);
    }

    public static SfFoodTruckResponse fail(String message) {
        return new SfFoodTruckResponse(1, message, null);
    }

    @Data
    @AllArgsConstructor
    private static class SfFoodTruckResponse {
        private int code;
        private String message;
        private Object result;
    }
}
