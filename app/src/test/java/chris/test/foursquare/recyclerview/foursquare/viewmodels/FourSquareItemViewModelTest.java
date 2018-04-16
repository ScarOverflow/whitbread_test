package chris.test.foursquare.recyclerview.foursquare.viewmodels;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareItemViewModelTest {
    @Mock
    private FourSquareStore mockFourSquareStore;
    @InjectMocks
    private FourSquareItemViewModel sut;

    @Test
    public void whenPublishThenCallStoresPublish() {
        final VenueBasic venueBasic = new VenueBasic();
        venueBasic.setName("venue");
        doNothing().when(mockFourSquareStore).publish(venueBasic);

        sut.publish(venueBasic);

        verify(mockFourSquareStore).publish(venueBasic);
    }

    @Test
    public void whenSetItemThenValuesAreSet() {
        final VenueBasic venueBasic = new VenueBasic();
        venueBasic.setName("venue");
        venueBasic.setImageUrl("url");

        sut.setItem(venueBasic);

        assertEquals(sut.name.get(), venueBasic.getName());
        assertEquals(sut.imageUrl.get(), venueBasic.getImageUrl());
    }
}
