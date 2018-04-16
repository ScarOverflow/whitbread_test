package chris.test.foursquare.services.foursquare;

import java.util.List;

import chris.test.foursquare.services.foursquare.repositories.FourSquareRepository;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Single;

public class FourSquareService implements FourSquareServiceApi {
    private final FourSquareRepository fourSquareRepository;

    public FourSquareService(FourSquareRepository fourSquareRepository) {
        this.fourSquareRepository = fourSquareRepository;
    }

    @Override
    public Single<List<VenueBasic>> search(final String query) {
        return fourSquareRepository.search(query);
    }
}
