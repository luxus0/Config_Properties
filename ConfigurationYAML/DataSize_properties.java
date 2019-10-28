package lukasz.nowogorski.SpringBoot.application_properties.ConfigurationYAML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataUnit;
import org.springframework.util.unit.DataSize;

@SuppressWarnings("ALL")
@EnableConfigurationProperties
@ConfigurationPropertiesBinding//import yml
@ConfigurationProperties(prefix = "data")
@PropertySource(value ="classpath:dataSize.yml")
public class DataSize_properties
{
    @DataSizeUnit(DataUnit.MEGABYTES)
    @Value("${bufferSize}")
    private DataSize bufferSize = DataSize.ofMegabytes(2);

    @DataSizeUnit(DataUnit.BYTES)
    @Value("${sizeThreshold}")
    private DataSize sizeThreshold = DataSize.ofBytes(512);

    @Value("${getBufferSize}")
    public DataSize getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(DataSize bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Value("${getSizeThreshold}")
    public DataSize getSizeThreshold() {
        return this.sizeThreshold;
    }

    public void setSizeThreshold(DataSize sizeThreshold) {
        this.sizeThreshold = sizeThreshold;
    }

}
