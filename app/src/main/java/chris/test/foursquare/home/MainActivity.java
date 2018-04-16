package chris.test.foursquare.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import chris.test.foursquare.R;
import chris.test.foursquare.databinding.ActivityMainBinding;
import chris.test.foursquare.home.viewmodels.MainActivityViewModel;
import chris.test.foursquare.recyclerview.foursquare.FourSquareItemAdapter;
import chris.test.foursquare.recyclerview.listeners.Refresh;
import chris.test.foursquare.ui.BaseActivity;
import dagger.android.AndroidInjection;

import static chris.test.foursquare.rx.RxTransformers.applyCompletableSchedulers;
import static chris.test.foursquare.rx.RxTransformers.applySchedulers;
import static chris.test.foursquare.rx.RxTransformers.consumeCompletableError;
import static chris.test.foursquare.rx.RxTransformers.consumeError;

public class MainActivity extends BaseActivity {

    @Inject
    protected MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.fruitToolbar);

        if (savedInstanceState == null) {
            AndroidInjection.inject(this);
            disposables.add(mainActivityViewModel.init()
                    .compose(applyCompletableSchedulers())
                    .compose(consumeCompletableError())
                    .subscribe(() -> setup(binding),
                            Throwable::printStackTrace));
        } else {
            mainActivityViewModel = (MainActivityViewModel) getLastCustomNonConfigurationInstance();
            setup(binding);
        }
    }

    private void setup(final ActivityMainBinding binding) {
//        binding.fruitRecyclerView.setAdapter(
//                new FourSquareItemAdapter(mainActivityViewModel.getVenueBasicsList(),
//                        mainActivityViewModel.getFourSquareStore()));
        binding.setViewModel(mainActivityViewModel);
        binding.swipeRefreshLayout.setOnRefreshListener(new Refresh(mainActivityViewModel));
        setupRefresh(binding);
    }

    private void setupRefresh(final ActivityMainBinding binding) {
        disposables.add(mainActivityViewModel.onFinished()
                .compose(applySchedulers())
                .compose(consumeError())
                .subscribe(binding.swipeRefreshLayout::setRefreshing));
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mainActivityViewModel;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_foursquare_toggle) {
            mainActivityViewModel.toggleIsGrid();
        }
        return super.onOptionsItemSelected(item);
    }
}
