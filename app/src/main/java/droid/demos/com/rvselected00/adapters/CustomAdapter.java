package droid.demos.com.rvselected00.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import droid.demos.com.rvselected00.Common.Common;
import droid.demos.com.rvselected00.R;
import droid.demos.com.rvselected00.interfaces.ItemClickListener;
import droid.demos.com.rvselected00.models.Item;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;
    private int rowIndex = -1;

    public CustomAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txvText.setText(itemList.get(position).getName());

        if (!itemList.get(position).isChecked()) {
            holder.imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_check_black_24dp);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                rowIndex = position;
                Common.currentItem = itemList.get(position);
                notifyDataSetChanged();
            }
        });

        if (rowIndex == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#F8F8FA"));
            holder.txvText.setTextColor(Color.parseColor("#C5C5C7"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.txvText.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView txvText;
        private ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            txvText = (TextView) itemView.findViewById(R.id.txvText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }

}
