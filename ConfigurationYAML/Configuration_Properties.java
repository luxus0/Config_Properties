package lukasz.nowogorski.SpringBoot.application_properties.ConfigurationYAML;

import spring_boot.spring_boot.rest.Bicycle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@ConfigurationProperties("config")
public class Configuration_Properties
{
    List<Bicycle> list = new ArrayList<>();

    public List<Bicycle> getBicycle()
    {
        return list;
    }

    public void setBicycle(List<Bicycle> bicycleList)
    {
        this.list = bicycleList;
    }

    @RequestMapping("/showBicycle")
    public List<Bicycle> showBicycle()
    {
        return list;
    }

}
