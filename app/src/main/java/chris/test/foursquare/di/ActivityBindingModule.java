package chris.test.foursquare.di;

import chris.test.foursquare.detail.DetailActivity;
import chris.test.foursquare.home.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = ViewModelsModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = ViewModelsModule.class)
    abstract DetailActivity detailActivity();
}