package chris.test.foursquare.events.stores;

public interface Publish<T> {
    void publish(T value);
}
