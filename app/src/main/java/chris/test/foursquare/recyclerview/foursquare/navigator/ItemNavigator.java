package chris.test.foursquare.recyclerview.foursquare.navigator;

import android.content.Context;
import android.content.Intent;

import chris.test.foursquare.detail.DetailActivity;
import chris.test.foursquare.events.stores.Publish;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;


public final class ItemNavigator {

    private ItemNavigator() {
        // do not instantiate
    }

    public static void navigateToDetail(final Context context, final Publish<VenueBasic> venueBasicPublish, final VenueBasic venueBasic) {
        venueBasicPublish.publish(venueBasic);
        final Intent intent = new Intent(context, DetailActivity.class);
        context.startActivity(intent);
    }
}
