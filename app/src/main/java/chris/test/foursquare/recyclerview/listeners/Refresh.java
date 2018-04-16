package chris.test.foursquare.recyclerview.listeners;

import android.support.v4.widget.SwipeRefreshLayout;

public class Refresh implements SwipeRefreshLayout.OnRefreshListener {
    private final RefreshAction refreshAction;

    public Refresh(RefreshAction refreshAction) {
        this.refreshAction = refreshAction;
    }

    @Override
    public void onRefresh() {
        refreshAction.refresh();
    }
}
