package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable {

    @SerializedName("indices")
    @Expose
    private List<Integer> indices = null;
    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = -764487016480782839L;

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
