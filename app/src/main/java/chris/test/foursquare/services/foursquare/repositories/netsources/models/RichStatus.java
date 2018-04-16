package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RichStatus implements Serializable {

    @SerializedName("entities")
    @Expose
    private List<Object> entities = null;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -3502421408180144529L;

    public List<Object> getEntities() {
        return entities;
    }

    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
