package chris.test.foursquare.rx;

import android.util.Log;

import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class RxTransformers {
    private final static String TAG = RxTransformers.class.getSimpleName();

    private RxTransformers() {
        // do not instantiate
    }

    public static CompletableTransformer applyCompletableSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static CompletableTransformer consumeCompletableError() {
        return observable -> observable.doOnError(e -> Log.e(TAG, e.getMessage()));
    }

    public static <T> ObservableTransformer<T, T> consumeError() {
        return observable -> observable.doOnError(e -> Log.e(TAG, e.getMessage()));
    }
}
