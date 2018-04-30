package com.yazhi1992.moon.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yazhi1992.moon.R;
import com.yazhi1992.moon.adapter.base.WithClicklistenerItemViewBinder;
import com.yazhi1992.moon.viewmodel.AddItemBean;

/**
 * Created by zengyazhi on 2018/2/5
 */
public class ItemDialogViewBinder extends WithClicklistenerItemViewBinder<String, ItemDialogViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_add_dialog, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void BindViewHolder(@NonNull ViewHolder holder, @NonNull String bean) {
        holder.mTvTitle.setText(bean);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
