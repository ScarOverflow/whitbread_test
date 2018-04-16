package chris.test.foursquare.di;

import android.app.Application;

import javax.inject.Singleton;

import chris.test.foursquare.FoursquareApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ViewModelsModule.class,
        DomainServicesModule.class,
        EventsModule.class})
public interface AppComponent extends AndroidInjector<FoursquareApplication> {
    @Override
    void inject(FoursquareApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}