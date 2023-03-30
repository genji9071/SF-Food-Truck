package github.genji9071.sfFoodTruck.controller;

import github.genji9071.sfFoodTruck.service.SfFoodTruckService;
import github.genji9071.sfFoodTruck.vo.SfFoodTruckDoListRequestBodyVO;
import github.genji9071.sfFoodTruck.vo.SfFoodTruckPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sf-food-truck")
public class SfFoodTruckController {

    @Autowired
    private SfFoodTruckService sfFoodTruckService;

    @PostMapping("/list")
    public SfFoodTruckPageVO doList(@RequestBody SfFoodTruckDoListRequestBodyVO requestBodyVO) {
        return sfFoodTruckService.doList(requestBodyVO.getPageNum(), requestBodyVO.getPageSize(), requestBodyVO.getFilterItems());
    }
}
