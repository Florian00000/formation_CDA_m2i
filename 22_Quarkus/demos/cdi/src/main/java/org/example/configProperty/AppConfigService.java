package org.example.configProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class AppConfigService {


    @Inject
    @ConfigProperty(name = "app.message")
    String message;

    @Inject
    @ConfigProperty(name = "app.version")
    String version;

    @Inject
    @ConfigProperty(name = "app.default.valor", defaultValue = "Je pas")
    String infos;

    @Inject
    @ConfigProperty(name = "app.feature-enabled")
    Boolean featureenabled;

    @Inject
    @ConfigProperty(name = "app.max-items")
    int maxitems;


    public String getMessage() {
        return message;
    }

    public String getVersion() {
        return version;
    }

    public String getInfos() {
        return infos;
    }

    public Boolean getFeatureenabled() {
        return featureenabled;
    }

    public int getMaxitems() {
        return maxitems;
    }
}
