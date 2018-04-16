package chris.test.foursquare.home.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.jakewharton.rxrelay2.PublishRelay;

import java.util.List;

import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.recyclerview.listeners.RefreshAction;
import chris.test.foursquare.services.foursquare.FourSquareServiceApi;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;
import io.reactivex.Completable;
import io.reactivex.Observable;

import static chris.test.foursquare.rx.RxTransformers.applyCompletableSchedulers;
import static chris.test.foursquare.rx.RxTransformers.consumeCompletableError;

public class MainActivityViewModel implements RefreshAction {
    public final ObservableBoolean isGrid = new ObservableBoolean();
    public final ObservableField<String> query = new ObservableField<>();
    public final ObservableArrayList<VenueBasic> data = new ObservableArrayList<>();

    private final PublishRelay<Boolean> onFinished = PublishRelay.create();

    private List<VenueBasic> venueBasicsList;
    private final FourSquareServiceApi fourSquareServiceApi;
    private final FourSquareStore fourSquareStore;

    public MainActivityViewModel(FourSquareServiceApi fourSquareServiceApi,
                                 FourSquareStore fourSquareStore) {
        this.fourSquareServiceApi = fourSquareServiceApi;
        this.fourSquareStore = fourSquareStore;
    }

    public Completable init() {
        return fourSquareServiceApi.search(query.get())
                .doOnSuccess(venueBasics -> {
                    venueBasicsList = venueBasics;
                    data.clear();
                    data.addAll(venueBasics);
                    onFinished.accept(false);
                })
                .toCompletable();
    }

    public FourSquareStore getFourSquareStore() {
        return fourSquareStore;
    }

    public List<VenueBasic> getVenueBasicsList() {
        return venueBasicsList;
    }

    public void toggleIsGrid() {
        isGrid.set(!isGrid.get());
    }

    @Override
    public void refresh() {
        init().compose(applyCompletableSchedulers())
                .compose(consumeCompletableError())
                .subscribe();
    }

    @Override
    public Observable<Boolean> onFinished() {
        return onFinished.hide();
    }

    public void search() {
        init().compose(applyCompletableSchedulers())
                .compose(consumeCompletableError())
                .subscribe();
    }
}
