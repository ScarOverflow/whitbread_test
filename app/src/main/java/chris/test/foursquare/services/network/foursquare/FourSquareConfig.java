package chris.test.foursquare.services.network.foursquare;

import chris.test.foursquare.services.network.RetrofitConfig;

public class FourSquareConfig implements RetrofitConfig {
    @Override
    public String getBaseUrl() {
        return "https://api.foursquare.com/v2/";
    }
}
