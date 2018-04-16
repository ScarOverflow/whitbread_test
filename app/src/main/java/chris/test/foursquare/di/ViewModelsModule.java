package chris.test.foursquare.di;

import chris.test.foursquare.detail.viewmodels.DetailActivityViewModel;
import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.home.viewmodels.MainActivityViewModel;
import chris.test.foursquare.services.foursquare.FourSquareService;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelsModule {

    @Provides
    MainActivityViewModel providesMainActivityViewModel(FourSquareService fourSquareService,
                                                        FourSquareStore fourSquareStore) {
        return new MainActivityViewModel(fourSquareService, fourSquareStore);
    }

    @Provides
    DetailActivityViewModel providesDetailActivityViewModel(FourSquareStore fourSquareStore) {
        return new DetailActivityViewModel(fourSquareStore);
    }
}
