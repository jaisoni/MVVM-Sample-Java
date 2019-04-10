package dev.jai.weather.ui.weather;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import dev.jai.weather.R;
import dev.jai.weather.databinding.ItemDailyDataBinding;
import dev.jai.weather.model.Daily;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class WeatherDetailsAdapter extends RecyclerView.Adapter<WeatherDetailsAdapter.ViewHolder> {
    private List<Daily.Data> dataList = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemDailyDataBinding binding = DataBindingUtil.inflate((LayoutInflater) viewGroup.getContext().getSystemService(LAYOUT_INFLATER_SERVICE),
                R.layout.item_daily_data, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.setData(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItems(List<Daily.Data> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.dataList.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected ItemDailyDataBinding binding;

        public ViewHolder(ItemDailyDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
