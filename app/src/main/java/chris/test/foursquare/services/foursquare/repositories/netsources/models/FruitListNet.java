package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FruitListNet {
    @SerializedName("fruit")
    private List<FruitNet> fruit;

    public List<FruitNet> getFruit() {
        return fruit;
    }

    public void setFruit(List<FruitNet> fruit) {
        this.fruit = fruit;
    }
}
