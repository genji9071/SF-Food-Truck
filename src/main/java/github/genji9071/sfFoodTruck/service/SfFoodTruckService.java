package github.genji9071.sfFoodTruck.service;

import github.genji9071.sfFoodTruck.entity.SfFoodTruckEntity;
import github.genji9071.sfFoodTruck.util.CsvConvertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class SfFoodTruckService {

    private List<SfFoodTruckEntity> allData;

    @PostConstruct
    public void build() {
        String csvFile = this.getClass().getClassLoader().getResource("Mobile_Food_Facility_Permit.csv").getPath();
        this.allData = CsvConvertUtils.csv2List(csvFile);
    }
}
