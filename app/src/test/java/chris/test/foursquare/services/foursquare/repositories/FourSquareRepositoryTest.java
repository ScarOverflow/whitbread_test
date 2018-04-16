package chris.test.foursquare.services.foursquare.repositories;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import chris.test.foursquare.rules.RxImmediateSchedulerRule;
import chris.test.foursquare.services.foursquare.repositories.netsources.FourSquareNetSource;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Explore;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Group;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Item;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Response;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Venue;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareRepositoryTest {
    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule = new RxImmediateSchedulerRule();
    @Mock
    private FourSquareNetSource mockFourSquareNetSource;
    @InjectMocks
    private FourSquareRepository sut;

    @Test
    public void whenSearchThenCallNetSourceSearch() {
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
        when(mockFourSquareNetSource.search(query)).thenReturn(Single.just(explore));

        sut.search(query)
                .test()
                .assertComplete()
                .assertNoErrors()
                .assertValue(venueBasicList -> venueBasicList.get(0).getName()
                        .equals(explore.getResponse().getGroups().get(0).getItems().get(0).getVenue().getName()));
        verify(mockFourSquareNetSource).search(query);
    }
}
