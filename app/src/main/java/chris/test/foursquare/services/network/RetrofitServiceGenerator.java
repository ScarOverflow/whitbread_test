package chris.test.foursquare.services.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator implements ServiceGenerator {
    private Retrofit retrofit;
    private final RetrofitConfig retrofitConfig;

    public RetrofitServiceGenerator(RetrofitConfig retrofitConfig) {
        this.retrofitConfig = retrofitConfig;
        initialise();
    }

    private void initialise() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(retrofitConfig.getBaseUrl())
                .build();
    }

    @Override
    public <Service> Service createService(Class<Service> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
