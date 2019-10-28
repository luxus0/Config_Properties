package lukasz.nowogorski.SpringBoot.application_properties.Enscrypting_properties;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Profiles;

import java.util.HashSet;
import java.util.Set;


public class Enscrypt_Property implements EnvironmentPostProcessor {

    ConfigurableEnvironment environment;
    SpringApplication application;

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {




        environment.addActiveProfile("Profile 1");
        environment.setIgnoreUnresolvableNestedPlaceholders(true);
        environment.setPlaceholderPrefix("-");
        environment.setPlaceholderSuffix(".");
        environment.setRequiredProperties("Property 1");
        environment.setValueSeparator("/");
        environment.acceptsProfiles(Profiles.of("1","2","3"));


        Set<String> source = new HashSet<>();
        source.add("lukasz.nowogorski.SpringBoot.SpringApplication.*");
        source.add("SOURCE 2");
        source.add("SOURCE 3");
        source.add("SOURCE 4");

        application.setLogStartupInfo(true);
        application.setAddCommandLineProperties(true);
        application.setAdditionalProfiles("PROFILE 1","PROFILE2", "PROFILE3");
        application.setAllowBeanDefinitionOverriding(true);
        application.setAddConversionService(true);
        application.setRegisterShutdownHook(true);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.setSources(source);
        application.setHeadless(true);

        application.setBeanNameGenerator(new BeanNameGenerator() {
            @Override
            public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

                definition.setRole(BeanDefinition.ROLE_APPLICATION);
                definition.setDescription("Some description");

                registry.getBeanDefinition("fun");

                return "GENERATED BEAN DEFINITION COMPLETE";
            }
        });

        System.out.println("WEB APPLICATION TYPE: " +application.getWebApplicationType());
        System.out.println("Class loader: " +application.getClassLoader());
        System.out.println("Initializers: " +application.getInitializers());
        System.out.println("Source: " +application.getAllSources());
        System.out.println("Resource loader: " +application.getResourceLoader());
        System.out.println("Main application Class: " +application.getMainApplicationClass());
        System.out.println("Listeners: " +application.getListeners());

    }



    public void main(String args[])
    {
        Enscrypt_Property encrypt = new Enscrypt_Property();
        encrypt.postProcessEnvironment(this.environment,this.application);
    }
}
