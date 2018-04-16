package chris.test.foursquare.services.foursquare.repositories.mappers;

import chris.test.foursquare.services.foursquare.repositories.models.Fruit;
import chris.test.foursquare.services.foursquare.repositories.netsources.models.FruitNet;

public final class FruitMapper {
    private FruitMapper() {
        // private
    }

    public static Fruit toFruit(final FruitNet fruitNet) {
        final Fruit newFruit = new Fruit();
        newFruit.setType(fruitNet.getType());
        newFruit.setPrice(fruitNet.getPrice());
        newFruit.setWeight(fruitNet.getWeight());
        return newFruit;
    }
}
