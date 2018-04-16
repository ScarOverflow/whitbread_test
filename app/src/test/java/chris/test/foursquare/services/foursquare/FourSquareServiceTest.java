package chris.test.foursquare.services.foursquare;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import chris.test.foursquare.rules.RxImmediateSchedulerRule;
import chris.test.foursquare.services.foursquare.repositories.FourSquareRepository;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareServiceTest {
    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule = new RxImmediateSchedulerRule();
    @Mock
    private FourSquareRepository mockFourSquareRepository;
    @InjectMocks
    private FourSquareService sut;

    @Test
    public void whenSearchThenCallRepositorySearch() {
        final VenueBasic venueBasic = new VenueBasic();
        venueBasic.setName("venue");
        final List<VenueBasic> venueBasics = new ArrayList<>();
        venueBasics.add(venueBasic);
        final String query = "query";
        when(mockFourSquareRepository.search(query)).thenReturn(Single.just(venueBasics));

        sut.search(query)
                .test()
                .assertNoErrors()
                .assertComplete()
                .assertValue(venueBasics1 -> venueBasics1.get(0).getName().equals(venueBasics.get(0).getName()));
        verify(mockFourSquareRepository).search(query);
    }
}
