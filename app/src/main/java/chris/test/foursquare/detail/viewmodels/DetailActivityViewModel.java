package chris.test.foursquare.detail.viewmodels;

import android.databinding.ObservableField;

import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Completable;

public class DetailActivityViewModel {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> rating = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();

    private final FourSquareStore fourSquareStore;

    public DetailActivityViewModel(FourSquareStore fourSquareStore) {
        this.fourSquareStore = fourSquareStore;
    }

    public Completable init() {
        return fourSquareStore.observe()
                .doOnNext(this::setItem)
                .ignoreElements();
    }

    private void setItem(final VenueBasic venueBasic) {
        name.set(venueBasic.getName());
        rating.set(venueBasic.getRating().toString());
        imageUrl.set(venueBasic.getImageUrl());
    }
}
