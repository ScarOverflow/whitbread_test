package chris.test.foursquare.services.foursquare.repositories.mappers;

import java.util.ArrayList;
import java.util.List;

import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Explore;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Group;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Item;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.Venue;

public final class VenueBasicMapper {
    private VenueBasicMapper() {
        // non explicit
    }

    public static List<VenueBasic> mapFrom(final Explore explore) {
        final List<VenueBasic> venueBasicList = new ArrayList<>();
        final List<Group> group = explore.getResponse().getGroups();
        if (group != null && !group.isEmpty()) {
            for (Item item : group.get(0).getItems()) {
                final Venue venue = item.getVenue();
                final VenueBasic venueBasic = new VenueBasic();
                venueBasic.setId(venue.getId());
                venueBasic.setName(venue.getName());
                venueBasic.setRating(venue.getRating());
                venueBasicList.add(venueBasic);
            }
        }
        return venueBasicList;
    }
}
