package com.nyongconnect.leaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyongconnect.leaderboard.R;
import com.nyongconnect.leaderboard.pojo.TopLearner;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.LeaderAdapterViewHolder> {
    Context mContext;
    LayoutInflater mLayoutInflater;
    List<TopLearner> mTopLearnerList;
    public LeaderAdapter(Context context, List<TopLearner> topLearnerList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mTopLearnerList = topLearnerList;
    }

    @NonNull
    @Override
    public LeaderAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.leadership_list, parent, false);
        return new LeaderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderAdapterViewHolder holder, int position) {
        holder.mTvLeaderName.setText(mTopLearnerList.get(position).getName());
        holder.mTvLeaderLocation.setText(mTopLearnerList.get(position).getHours() +" learning hours, "+ mTopLearnerList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        if (mTopLearnerList != null) return mTopLearnerList.size();
        return 3;
    }

    class LeaderAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView mTvLeaderName, mTvLeaderLocation;
        public LeaderAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvLeaderName = itemView.findViewById(R.id.tv_leader_name);
            mTvLeaderLocation = itemView.findViewById(R.id.tv_leader_location);
        }
    }
}
