package chris.test.foursquare.recyclerview.listeners;

import io.reactivex.Observable;

public interface RefreshAction {
    void refresh();

    Observable<Boolean> onFinished();
}
