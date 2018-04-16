package chris.test.foursquare.services.foursquare.repositories;

import java.util.List;

import chris.test.foursquare.services.foursquare.repositories.mappers.VenueBasicMapper;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import chris.test.foursquare.services.foursquare.repositories.netsources.FourSquareNetSource;
import io.reactivex.Single;

public class FourSquareRepository {
    private final FourSquareNetSource fourSquareNetSource;

    public FourSquareRepository(FourSquareNetSource fourSquareNetSource) {
        this.fourSquareNetSource = fourSquareNetSource;
    }

    public Single<List<VenueBasic>> search(final String query) {
        return fourSquareNetSource.search(query)
                .map(VenueBasicMapper::mapFrom);
    }
}
