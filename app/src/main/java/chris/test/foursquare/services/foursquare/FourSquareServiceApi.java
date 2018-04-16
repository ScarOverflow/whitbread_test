package chris.test.foursquare.services.foursquare;

import java.util.List;

import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Single;

public interface FourSquareServiceApi {
    Single<List<VenueBasic>> search(final String query);
}
