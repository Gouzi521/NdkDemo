package com.hyperfd.ndkdemo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/3/6 9:01
 */
public class GlideRecyclerView extends RecyclerView {


    public GlideRecyclerView(@NonNull Context context) {
        super(context);
    }

    public GlideRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GlideRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addOnScrollListener(new ImageAutoLoadScrollListener());
    }

    public class ImageAutoLoadScrollListener extends OnScrollListener{

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            switch (newState){
                case SCROLL_STATE_IDLE:
                    if (getContext()!=null)
                        Glide.with(getContext()).resumeRequests();
                    break;
            }
        }
    }
}
