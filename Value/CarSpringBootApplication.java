package lukasz.nowogorski.SpringBoot.application_properties.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@SpringBootApplication
@EnableConfigurationProperties(CarSpringBootApplication.class)
@ConfigurationProperties(prefix ="info")
@ConfigurationPropertiesBinding
@PropertySource(value = "classpath:info.yml")
public class CarSpringBootApplication implements CommandLineRunner {


    @Valid//walidacja
    @NotNull
    @Value("${color}")
    private String color;

    @Valid
    @NotNull
    @Value("${adress}")
    private String address;

    @Value("${getColor}")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Value("${getAdress}")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    public static void main(String[] args) throws Exception {

        SpringApplication.run(CarSpringBootApplication.class, args);

        new SpringApplicationBuilder().logStartupInfo(true);
        CarSpringBootApplication m = new CarSpringBootApplication();
        m.run("");

    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println(color);
        System.out.println(address);

    }
}
