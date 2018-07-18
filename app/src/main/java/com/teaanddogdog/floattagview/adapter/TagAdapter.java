package com.teaanddogdog.floattagview.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.teaanddogdog.floattagview.R;
import com.teaanddogdog.floattagview.ToastHelper;
import com.teaanddogdog.floattagview.bean.Demo;
import com.teaanddogdog.floattagviewlib.indicator.base.IndicatorBaseView;

import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author banbury
 * @version v1.0
 * @created 2018/7/11_15:12.
 * @description
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private List<Demo> mDemoList;
    @LayoutRes
    private int mLayout;

    public TagAdapter(List<Demo> demos, @LayoutRes int layout) {
        mDemoList = demos;
        mLayout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Demo demo = mDemoList.get(position);
        Glide.with(holder.mImageViewItem.getContext()).load(demo.getImage()).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.mImageViewItem);
        holder.mTvText.setText(demo.getNick());
        holder.mView.hide();
        Random random = new Random();
        holder.mView.setBackgroundColor(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mView.isShow()) {
                    ToastHelper.getInstance().showToast(holder.mImageViewItem.getContext(), position + "被点击了");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDemoList == null ? 0 : mDemoList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.image_view_item)
        ImageView mImageViewItem;
        @Bind(R.id.tv_text)
        TextView mTvText;

        IndicatorBaseView mView;

        ViewHolder(View view) {
            super(view);
            mView = (IndicatorBaseView) view;
            ButterKnife.bind(this, view);
        }
    }
}
