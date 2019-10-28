package lukasz.nowogorski.SpringBoot.application_properties.ConfigurationYAML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SuppressWarnings("ALL")
@EnableConfigurationProperties
@ConfigurationProperties(prefix ="duration")
@ConfigurationPropertiesBinding
@PropertySource(value = "classpath:durationFile.yml")
public class Duration_Time
{
    @DurationUnit(ChronoUnit.SECONDS)
    @Value("${second}")
    private Duration second = Duration.ofSeconds(50);

    @DurationUnit(ChronoUnit.MILLIS)
    @Value("${milisecond}")
    private Duration milisecond = Duration.ofMillis(2000);

    @Value("${getSecond}")
    public Duration getSecond() {
        return second;
    }

    public void setSecond(Duration second) {
        this.second = second;
    }

    @Value("${getMilisecond}")
    public Duration getMilisecond() {
        return milisecond;
    }

    public void setMilisecond(Duration milisecond) {
        this.milisecond = milisecond;
    }
}
