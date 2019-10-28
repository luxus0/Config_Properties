package lukasz.nowogorski.SpringBoot.application_properties.Validate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "valid")
@ConfigurationPropertiesBinding
@Validated
public class ValidatorClass {

    @Value("${port}")
    @Valid
    @NotNull
    private int port;

    @Value("${name}")
    @Valid
    private String name;

    @Value("${passw}")
    @Valid
    private String passw;
}
