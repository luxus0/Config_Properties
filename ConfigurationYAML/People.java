package lukasz.nowogorski.SpringBoot.application_properties.ConfigurationYAML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SuppressWarnings("ALL")
@EnableConfigurationProperties
@ConfigurationProperties(prefix ="people")
@ConfigurationPropertiesBinding
@PropertySource(value = "classpath:people_yml.yml")
public class People
{
    @Value("name")
    private String name;

    @Value("surname")
    private String surname;

    @Value("age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
