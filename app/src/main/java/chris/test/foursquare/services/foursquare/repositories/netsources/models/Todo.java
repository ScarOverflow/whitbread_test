package chris.test.foursquare.services.foursquare.repositories.netsources.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Todo implements Serializable {

    @SerializedName("count")
    @Expose
    private Integer count;
    private final static long serialVersionUID = 8948374381208176013L;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
