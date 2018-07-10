package backend.controller;

import backend.entity.DataBlock;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@RequestMapping("statistics")
public interface StatisticsController {

    @GetMapping("/getall")
    List<DataBlock> getAll();

    @GetMapping("/refresh")
    void refreshData();

    @GetMapping("/getYear")
    List<DataBlock> getYear();

    @GetMapping("/getMonth")
    List<DataBlock> getMonth();

    @GetMapping("/getWeek")
    List<DataBlock> getWeek();

    @GetMapping("/getDay")
    List<DataBlock> getDay();
}
