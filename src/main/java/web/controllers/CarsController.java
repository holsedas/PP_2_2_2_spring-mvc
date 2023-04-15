package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarService;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String index(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> list;
        if (count > 0 && count < 5) {
            list = carService.cars().subList(0, count);
        } else if (count >= 5) {
            list = carService.cars();
        } else {
            list = null;
        }
        model.addAttribute("cars", list);
        return "cars";
    }
}