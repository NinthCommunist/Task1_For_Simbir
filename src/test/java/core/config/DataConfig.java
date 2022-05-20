package core.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:standProp/application.properties"})
public interface DataConfig extends Config {

    @Key("url")
    String getUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}
