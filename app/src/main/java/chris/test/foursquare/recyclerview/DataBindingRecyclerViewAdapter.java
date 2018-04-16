package chris.test.foursquare.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import chris.test.foursquare.recyclerview.viewmodels.ItemViewModel;

public abstract class DataBindingRecyclerViewAdapter<ITEM, VIEW_MODEL extends ItemViewModel<ITEM>>
        extends RecyclerView.Adapter<DataBindingRecyclerViewAdapter.ItemViewHolder<ITEM, VIEW_MODEL>> {

    protected final List<ITEM> items = new ArrayList<>();

    public DataBindingRecyclerViewAdapter(final List<ITEM> data) {
        items.addAll(data);
    }

    @Override
    public final void onBindViewHolder(ItemViewHolder<ITEM, VIEW_MODEL> holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void updateData(final List<ITEM> data) {
        items.clear();
        items.addAll(data);
        notifyDataSetChanged();
    }

    public static class ItemViewHolder<T, VT extends ItemViewModel<T>> extends RecyclerView.ViewHolder {

        protected final VT viewModel;
        private final ViewDataBinding binding;

        public ItemViewHolder(View itemView, ViewDataBinding binding, VT viewModel) {
            super(itemView);
            this.binding = binding;
            this.viewModel = viewModel;
        }

        void setItem(final T item) {
            viewModel.setItem(item);
            binding.executePendingBindings();
        }
    }
}
