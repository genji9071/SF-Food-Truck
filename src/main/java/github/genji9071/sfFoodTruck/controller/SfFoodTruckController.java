package github.genji9071.sfFoodTruck.controller;

import github.genji9071.sfFoodTruck.service.SfFoodTruckService;
import github.genji9071.sfFoodTruck.vo.SfFoodTruckVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sf-food-truck")
public class SfFoodTruckController{

    @Autowired
    private SfFoodTruckService sfFoodTruckService;

    @PostMapping("/list")
    public List<SfFoodTruckVO> doList() {
        return null;
    }
}
