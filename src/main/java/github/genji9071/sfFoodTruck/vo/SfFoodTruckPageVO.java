package github.genji9071.sfFoodTruck.vo;

import lombok.Data;

import java.util.List;

@Data
public class SfFoodTruckPageVO {
    List<SfFoodTruckVO> result;
    Integer totalCount;
    Integer pageSize;
    Integer currentPageNum;
}
