package chris.test.foursquare.detail.viewmodels;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.rules.RxImmediateSchedulerRule;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailActivityViewModelTest {
    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule = new RxImmediateSchedulerRule();
    @Mock
    private FourSquareStore mockFourSquareStore;
    @InjectMocks
    private DetailActivityViewModel sut;

    private VenueBasic venueBasic;

    @Before
    public void setup() {
        venueBasic = new VenueBasic();
        venueBasic.setId("1");
        venueBasic.setName("Venue");
        venueBasic.setRating(5.0);
        venueBasic.setImageUrl("url");
        when(mockFourSquareStore.observe()).thenReturn(Observable.just(venueBasic));
    }

    @Test
    public void whenInitThenCallFourSquareStoreObserveAndSetData() {
        sut.init()
                .test()
                .assertComplete()
                .assertNoErrors();
        verify(mockFourSquareStore).observe();
        assertEquals(sut.name.get(), venueBasic.getName());
        assertEquals(sut.rating.get(), venueBasic.getRating().toString());
        assertEquals(sut.imageUrl.get(), venueBasic.getImageUrl());
    }
}
