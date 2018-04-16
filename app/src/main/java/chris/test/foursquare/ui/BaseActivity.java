package chris.test.foursquare.ui;

import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity {
    protected final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        disposables.clear();
        super.onDestroy();
    }
}
