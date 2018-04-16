package chris.test.foursquare.di;

import javax.inject.Singleton;

import chris.test.foursquare.services.foursquare.FourSquareService;
import chris.test.foursquare.services.foursquare.repositories.FourSquareRepository;
import chris.test.foursquare.services.foursquare.repositories.netsources.FourSquareNetSource;
import chris.test.foursquare.services.network.RetrofitServiceGenerator;
import chris.test.foursquare.services.network.foursquare.FourSquareConfig;
import chris.test.foursquare.services.network.foursquare.FourSquareRestServiceApi;
import dagger.Module;
import dagger.Provides;

@Module
public class DomainServicesModule {

    @Provides
    FourSquareConfig providesFruitConfig() {
        return new FourSquareConfig();
    }

    @Singleton
    @Provides
    FourSquareRestServiceApi providesFruitRestServiceApi(FourSquareConfig fourSquareConfig) {
        return new RetrofitServiceGenerator(fourSquareConfig).createService(FourSquareRestServiceApi.class);
    }

    @Provides
    FourSquareNetSource providesFruitNetSource(FourSquareRestServiceApi fourSquareRestServiceApi) {
        return new FourSquareNetSource(fourSquareRestServiceApi);
    }

    @Provides
    FourSquareRepository providesFruitRepository(FourSquareNetSource fourSquareNetSource) {
        return new FourSquareRepository(fourSquareNetSource);
    }

    @Provides
    FourSquareService providesFruitService(FourSquareRepository fourSquareRepository) {
        return new FourSquareService(fourSquareRepository);
    }
}
