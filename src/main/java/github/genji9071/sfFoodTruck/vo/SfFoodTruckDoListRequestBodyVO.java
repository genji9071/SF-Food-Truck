package github.genji9071.sfFoodTruck.vo;

import lombok.Data;

import java.util.Map;

@Data
public class SfFoodTruckDoListRequestBodyVO {
    private Integer pageSize = 10;
    private Integer pageNum = 1;
    private Map<String, Object> filterItems;
}
