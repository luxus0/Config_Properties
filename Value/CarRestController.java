package spring_boot.spring_boot.config.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRestController
{
    @Autowired
    private CarRepo repo;

    @GetMapping("/getCar")
    public String showCar(@RequestParam String name, @RequestParam String mark, @RequestParam String model, @RequestParam String color,@RequestParam int wage)
    {

        return String.valueOf(repo.findAll().iterator().next());
    }



}
