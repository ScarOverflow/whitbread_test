package chris.test.foursquare.recyclerview.foursquare;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import chris.test.foursquare.R;
import chris.test.foursquare.databinding.FoursquareItemBinding;
import chris.test.foursquare.events.stores.FourSquareStore;
import chris.test.foursquare.recyclerview.DataBindingRecyclerViewAdapter;
import chris.test.foursquare.recyclerview.foursquare.viewmodels.FourSquareItemViewModel;
import chris.test.foursquare.services.foursquare.repositories.models.VenueBasic;

public class FourSquareItemAdapter extends DataBindingRecyclerViewAdapter<VenueBasic, FourSquareItemViewModel> {
    private final FourSquareStore fourSquareStore;

    public FourSquareItemAdapter(final List<VenueBasic> venueBasicList, FourSquareStore fourSquareStore) {
        super(venueBasicList);
        this.fourSquareStore = fourSquareStore;
    }

    @NonNull
    @Override
    public ItemViewHolder<VenueBasic, FourSquareItemViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.foursquare_item, parent, false);
        final FourSquareItemViewModel viewModel = new FourSquareItemViewModel(fourSquareStore);
        final FoursquareItemBinding binding = FoursquareItemBinding.bind(itemView);
        binding.setViewModel(viewModel);

        return new FourSquareItemViewHolder(itemView, binding, viewModel);
    }

    static class FourSquareItemViewHolder extends ItemViewHolder<VenueBasic, FourSquareItemViewModel> {

        FourSquareItemViewHolder(View itemView, ViewDataBinding binding, FourSquareItemViewModel viewModel) {
            super(itemView, binding, viewModel);
        }
    }
}
