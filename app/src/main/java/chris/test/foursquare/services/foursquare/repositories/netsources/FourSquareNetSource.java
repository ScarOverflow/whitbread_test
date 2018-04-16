package chris.test.foursquare.services.foursquare.repositories.netsources;

import chris.test.foursquare.services.foursquare.repositories.netsources.models.Explore;
import chris.test.foursquare.services.network.foursquare.FourSquareRestServiceApi;
import io.reactivex.Single;

public class FourSquareNetSource {
    private static final String CLIENT_ID = "NQ3GDLCGLCCKZDZYIW0W4FSV0AWWJNCWSP2QDENAFSGSHK0K";
    private static final String CLIENT_SECRET = "JD1QESXHZ2GLXX54HSBS4R3JLMKYPTV0MBEUEZ4RONVPXFJ1";
    private static final String V = "20180101";
    private static final String LL = "40.7,-74";
    private static final String LIMIT = "2";

    private final FourSquareRestServiceApi fourSquareRestServiceApi;

    public FourSquareNetSource(FourSquareRestServiceApi fourSquareRestServiceApi) {
        this.fourSquareRestServiceApi = fourSquareRestServiceApi;
    }

    public Single<Explore> search(final String query) {
        return fourSquareRestServiceApi.search(CLIENT_ID,
                CLIENT_SECRET,
                V,
                LL,
                LIMIT,
                query);
    }
}
