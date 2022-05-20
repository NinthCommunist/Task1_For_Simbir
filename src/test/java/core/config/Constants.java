package core.config;

import org.aeonbits.owner.ConfigFactory;

public class Constants {
    private static DataConfig dataConfig = ConfigFactory.newInstance().create(DataConfig.class);

    public static final String BASE_URL = dataConfig.getUrl();
    public static final String LOGIN = dataConfig.getLogin();
    public static final String PASSWORD= dataConfig.getPassword();
}
