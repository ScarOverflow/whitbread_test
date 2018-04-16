package chris.test.foursquare.home.viewmodels;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import chris.test.foursquare.rules.RxImmediateSchedulerRule;
import chris.test.foursquare.services.foursquare.FourSquareServiceApi;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityViewModelTest {
    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule = new RxImmediateSchedulerRule();
    @Mock
    private FourSquareServiceApi mockFourSquareServiceApi;
    @InjectMocks
    private MainActivityViewModel sut;

    @Test
    public void whenSearchThenCallFourSquareServiceSearch() {
        final VenueBasic venueBasic = new VenueBasic();
        venueBasic.setName("venue");
        venueBasic.setRating(10.0);
        venueBasic.setImageUrl("url");
        final List<VenueBasic> venueBasicList = Arrays.asList(venueBasic, venueBasic);
        sut.query.set("tacos");
        when(mockFourSquareServiceApi.search(sut.query.get())).thenReturn(Single.just(venueBasicList));

        sut.init()
                .test()
                .assertComplete()
                .assertNoErrors();
        verify(mockFourSquareServiceApi).search(sut.query.get());
        assertEquals(sut.getVenueBasicsList().get(0).getName(), venueBasic.getName());
    }
}
