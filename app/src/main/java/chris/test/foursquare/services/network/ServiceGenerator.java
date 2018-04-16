package chris.test.foursquare.services.network;

public interface ServiceGenerator {
    <Service> Service createService(Class<Service> serviceClass);
}
