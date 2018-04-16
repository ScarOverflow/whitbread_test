package chris.test.foursquare.recyclerview.foursquare.viewmodels;

import android.databinding.ObservableField;

import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.events.stores.Publish;
import chris.test.foursquare.recyclerview.viewmodels.ItemViewModel;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;

public class FourSquareItemViewModel implements ItemViewModel<VenueBasic>, Publish<VenueBasic> {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();
    private VenueBasic venueBasic;
    private final FourSquareStore fourSquareStore;

    public FourSquareItemViewModel(FourSquareStore fourSquareStore) {
        this.fourSquareStore = fourSquareStore;
    }

    @Override
    public void setItem(final VenueBasic venueBasic) {
        this.venueBasic = venueBasic;
        name.set(venueBasic.getName());
        imageUrl.set(venueBasic.getImageUrl());
    }

    public VenueBasic getVenueBasic() {
        return venueBasic;
    }

    @Override
    public void publish(VenueBasic fruit) {
        fourSquareStore.publish(fruit);
    }
}
