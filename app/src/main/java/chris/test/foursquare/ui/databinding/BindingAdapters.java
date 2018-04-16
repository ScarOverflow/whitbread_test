package chris.test.foursquare.ui.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import chris.test.foursquare.R;
import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.recyclerview.foursquare.FourSquareItemAdapter;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;

public class BindingAdapters {

    @BindingAdapter("loadImage")
    public static void loadImage(final ImageView imageView, final String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }

    @BindingAdapter("toggleLayoutManager")
    public static void toggleLayoutManager(final RecyclerView recyclerView, final boolean isGrid) {
        recyclerView.setLayoutManager(isGrid ?
                new GridLayoutManager(recyclerView.getContext(), 2) :
                new LinearLayoutManager(recyclerView.getContext()));
    }

    @BindingAdapter({"updateData", "setStore"})
    public static void updateData(final RecyclerView recyclerView,
                                  final List<VenueBasic> data,
                                  final FourSquareStore fourSquareStore) {
        if (data != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new FourSquareItemAdapter(data, fourSquareStore));
            } else {
                ((FourSquareItemAdapter) recyclerView.getAdapter()).updateData(data);
            }
        }
    }
}
