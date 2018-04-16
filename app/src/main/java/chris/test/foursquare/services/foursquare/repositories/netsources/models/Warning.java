package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Warning implements Serializable {

    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -9166776601562911746L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
