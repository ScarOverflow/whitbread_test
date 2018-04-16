package chris.test.foursquare.services.foursquare.repositories.netsources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import chris.test.foursquare.rules.RxImmediateSchedulerRule;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Explore;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Group;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Item;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Response;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Venue;
import chris.test.foursquare.services.network.foursquare.FourSquareRestServiceApi;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareNetSourceTest {
    private static final String CLIENT_ID = "NQ3GDLCGLCCKZDZYIW0W4FSV0AWWJNCWSP2QDENAFSGSHK0K";
    private static final String CLIENT_SECRET = "JD1QESXHZ2GLXX54HSBS4R3JLMKYPTV0MBEUEZ4RONVPXFJ1";
    private static final String V = "20180101";
    private static final String LL = "40.7,-74";
    private static final String LIMIT = "2";

    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule = new RxImmediateSchedulerRule();
    @Mock
    private FourSquareRestServiceApi mockFourSquareRestServiceApi;
    @InjectMocks
    private FourSquareNetSource sut;

    @Test
    public void whenSearchThenCallFurSquareServiceSearch() {
        final Explore explore = new Explore();
        final Response response = new Response();
        explore.setResponse(response);
        final List<Group> groups = new ArrayList<>();
        final Group group = new Group();
        final List<Item> items = new ArrayList<>();
        final Item item = new Item();
        final Venue venue = new Venue();
        venue.setId("1");
        venue.setName("name");
        venue.setRating(1.0);
        item.setVenue(venue);
        items.add(item);
        group.setItems(items);
        groups.add(group);
        response.setGroups(groups);
        final String query = "query";
        when(mockFourSquareRestServiceApi.search(CLIENT_ID,
                CLIENT_SECRET,
                V,
                LL,
                LIMIT,
                query)).thenReturn(Single.just(explore));

        sut.search(query)
                .test()
                .assertComplete()
                .assertNoErrors()
                .assertValue(explore1 -> explore1.getResponse().getGroups().get(0).getItems().get(0).getVenue().getName()
                        .equals(explore.getResponse().getGroups().get(0).getItems().get(0).getVenue().getName()));
        verify(mockFourSquareRestServiceApi).search(CLIENT_ID,
                CLIENT_SECRET,
                V,
                LL,
                LIMIT,
                query);
    }
}
