package github.genji9071.sfFoodTruck.service;

import com.alibaba.fastjson.JSONObject;
import github.genji9071.sfFoodTruck.entity.SfFoodTruckEntity;
import github.genji9071.sfFoodTruck.exception.SfFoodTruckException;
import github.genji9071.sfFoodTruck.util.CsvConvertUtils;
import github.genji9071.sfFoodTruck.util.ObjectUtils;
import github.genji9071.sfFoodTruck.vo.SfFoodTruckPageVO;
import github.genji9071.sfFoodTruck.vo.SfFoodTruckVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SfFoodTruckService {

    private List<SfFoodTruckEntity> allData;

    @PostConstruct
    public void build() {
        String csvFile = this.getClass().getClassLoader().getResource("Mobile_Food_Facility_Permit.csv").getPath();
        this.allData = CsvConvertUtils.csv2List(csvFile);
    }

    public SfFoodTruckPageVO doList(Integer pageNum, Integer pageSize, Map<String, Object> filterItems) {
        if (pageNum <= 0) {
            throw new SfFoodTruckException("[Wrong pageNum] pageNum must be larger than 0");
        }
        if (pageSize <= 0) {
            throw new SfFoodTruckException("[Wrong pageSize] pageSize must be larger than 0");
        }
        SfFoodTruckPageVO result = new SfFoodTruckPageVO();
        result.setPageSize(pageSize);
        result.setCurrentPageNum(pageNum);
        List<SfFoodTruckEntity> rawResult = this.getSearchResultByFilterItems(filterItems);
        List<SfFoodTruckVO> searchResult = this.buildAndPageVO(rawResult, pageNum, pageSize);
        result.setResult(searchResult);
        result.setTotalCount(rawResult.size());
        return result;
    }

    private List<SfFoodTruckVO> buildAndPageVO(List<SfFoodTruckEntity> rawResult, Integer pageNum, Integer pageSize) {
        List<SfFoodTruckEntity> pagedEntityList = rawResult.subList(pageNum * pageSize - pageSize, pageNum * pageSize);
        return pagedEntityList.stream().map(this::buildVO).collect(Collectors.toList());
    }

    private SfFoodTruckVO buildVO(SfFoodTruckEntity entity) {
        SfFoodTruckVO sfFoodTruckVO = ObjectUtils.copyProperties(entity, SfFoodTruckVO.class);
        sfFoodTruckVO.setName(entity.getApplicant());
        return sfFoodTruckVO;
    }

    private List<SfFoodTruckEntity> getSearchResultByFilterItems(Map<String, Object> filterItems) {
        if (CollectionUtils.isEmpty(filterItems)) {
            return allData;
        }
        List<JSONObject> jsonDataList = allData.stream().map(ObjectUtils::toJson).collect(Collectors.toList());
        List<JSONObject> filtered = jsonDataList.stream().filter(data -> {
            for (Map.Entry<String, Object> entry : filterItems.entrySet()) {
                if (Boolean.FALSE.equals(data.getString(entry.getKey()).contains(entry.getValue() + ""))) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());
        return filtered.stream().map(data -> data.toJavaObject(SfFoodTruckEntity.class)).collect(Collectors.toList());
    }
}
