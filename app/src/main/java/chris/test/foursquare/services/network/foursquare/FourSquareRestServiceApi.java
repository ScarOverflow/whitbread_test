package chris.test.foursquare.services.network.foursquare;

import chris.test.foursquare.services.foursquare.repositories.netsources.models.Explore;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourSquareRestServiceApi {
    @GET("venues/explore/")
    Single<Explore> search(@Query("client_id") String client_id,
                           @Query("client_secret") String client_secret,
                           @Query("v") String v,
                           @Query("ll") String ll,
                           @Query("limit") String limit,
                           @Query("query") String query);
}
