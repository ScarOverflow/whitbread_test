package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VenuePage implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    private final static long serialVersionUID = 7161023375448455919L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
