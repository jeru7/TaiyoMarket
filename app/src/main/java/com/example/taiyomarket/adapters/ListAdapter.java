package com.example.taiyomarket.adapters;

import androidx.recyclerview.widget.RecyclerView;
import com.example.taiyomarket.R;
import com.example.taiyomarket.classes.ListItem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<ListItem> items;

    public ListAdapter(List<ListItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListItem item = items.get(position);
        holder.listName.setText(item.getListName());
        holder.lastUpdate.setText("Last updated since " + item.getLastUpdate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView listName;
        TextView lastUpdate;

        ListViewHolder(View itemView) {
            super(itemView);
            listName = itemView.findViewById(R.id.list_name);
            lastUpdate = itemView.findViewById(R.id.last_update);
        }
    }
}