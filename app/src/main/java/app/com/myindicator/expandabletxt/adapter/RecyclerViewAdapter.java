package app.com.myindicator.expandabletxt.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import app.com.myindicator.R;
import app.com.myindicator.expandabletxt.ContentModel;
import app.com.myprogressbar.expandable_txt.TextViewExpandableAnimation;

/**
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<ContentModel> mLists;

    public RecyclerViewAdapter(List<ContentModel> lists) {
        this.mLists = lists;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_view, null));
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {
        //record its state
        holder.tvExpand.setOnStateChangeListener(new TextViewExpandableAnimation.OnStateChangeListener() {
            @Override
            public void onStateChange(boolean isShrink) {
                ContentModel cm = mLists.get(position);
                cm.setShrink(isShrink);
                mLists.set(position, cm);
            }
        });
        holder.tvExpand.setText(mLists.get(position).getText());
        //important! reset its state as where it left
        holder.tvExpand.resetState(mLists.get(position).isShrink());

    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextViewExpandableAnimation tvExpand;

        public ViewHolder(View itemView) {
            super(itemView);
            tvExpand = (TextViewExpandableAnimation) itemView.findViewById(R.id.tv_expand);
        }
    }
}
