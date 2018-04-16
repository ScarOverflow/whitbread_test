package chris.test.foursquare.di;

import javax.inject.Singleton;

import chris.test.foursquare.events.stores.FourSquareStore;
import dagger.Module;
import dagger.Provides;

@Module
public class EventsModule {

    @Singleton
    @Provides
    FourSquareStore providesFruitStore() {
        return new FourSquareStore();
    }
}
