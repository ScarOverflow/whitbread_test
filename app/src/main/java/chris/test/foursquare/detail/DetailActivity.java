package chris.test.foursquare.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import javax.inject.Inject;

import chris.test.foursquare.R;
import chris.test.foursquare.databinding.ActivityDetailBinding;
import chris.test.foursquare.detail.viewmodels.DetailActivityViewModel;
import chris.test.foursquare.ui.BaseActivity;
import dagger.android.AndroidInjection;

import static chris.test.foursquare.rx.RxTransformers.applyCompletableSchedulers;
import static chris.test.foursquare.rx.RxTransformers.consumeCompletableError;

public class DetailActivity extends BaseActivity {
    @Inject
    protected DetailActivityViewModel detailActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        setupToolbar(binding);

        if (savedInstanceState == null) {
            AndroidInjection.inject(this);
        } else {
            detailActivityViewModel = (DetailActivityViewModel) getLastCustomNonConfigurationInstance();
        }
        binding.setViewModel(detailActivityViewModel);
        disposables.add(detailActivityViewModel.init()
                .compose(applyCompletableSchedulers())
                .compose(consumeCompletableError())
                .subscribe());
    }

    private void setupToolbar(final ActivityDetailBinding binding) {
        setSupportActionBar(binding.foursquareToolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return detailActivityViewModel;
    }
}
