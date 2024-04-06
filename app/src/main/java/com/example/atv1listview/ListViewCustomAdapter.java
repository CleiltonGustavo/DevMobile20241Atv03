package com.example.atv1listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewCustomAdapter extends BaseAdapter {

    Context context;
    String[] items;

    ListViewCustomAdapter(Context context, String[] items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.layout_test, parent, false);

            holder = new ViewHolder();
            holder.tvLayout = convertView.findViewById(R.id.tvLayout);
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.tvLuas = convertView.findViewById(R.id.tvLuas);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvLayout.setText(items[position]);


        if (getItemId(position) == 0){
            holder.imageView.setBackgroundResource(R.drawable.mercurio);
            holder.tvLuas.setText("0 Lua(s)");
        } else if (getItemId(position) == 1){
            holder.imageView.setBackgroundResource(R.drawable.venus);
            holder.tvLuas.setText("0 Lua(s)");
        } else if (getItemId(position) == 2){
            holder.imageView.setBackgroundResource(R.drawable.terra);
            holder.tvLuas.setText("1 Lua(s)");
        } else if (getItemId(position) == 3){
            holder.imageView.setBackgroundResource(R.drawable.marte);
            holder.tvLuas.setText("2 Lua(s)");
        } else if (getItemId(position) == 4){
            holder.imageView.setBackgroundResource(R.drawable.jupiter);
            holder.tvLuas.setText("79 Lua(s)");
        } else if (getItemId(position) == 5){
            holder.imageView.setBackgroundResource(R.drawable.saturn);
            holder.tvLuas.setText("83 Lua(s)");
        } else if (getItemId(position) == 6){
            holder.imageView.setBackgroundResource(R.drawable.urano);
            holder.tvLuas.setText("27 Lua(s)");
        } else if (getItemId(position) == 7){
            holder.imageView.setBackgroundResource(R.drawable.netuno);
            holder.tvLuas.setText("14 Lua(s)");
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicou no item " + items[position], Toast.LENGTH_SHORT).show();

            }
        });


        return convertView;
    }

    static class ViewHolder{
        TextView tvLuas;
        TextView tvLayout;
        ImageView imageView;
    }
}
