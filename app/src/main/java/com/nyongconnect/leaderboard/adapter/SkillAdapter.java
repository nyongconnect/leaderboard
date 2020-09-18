package com.nyongconnect.leaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyongconnect.leaderboard.R;
import com.nyongconnect.leaderboard.pojo.TopSkill;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillAdapterViewHolder> {
    List<TopSkill> mTopSkillList;
    Context mContext;
    LayoutInflater mLayoutInflater;
    public SkillAdapter(Context context,  List<TopSkill> topSkillList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mTopSkillList = topSkillList;
    }

    @NonNull
    @Override
    public SkillAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.skill_iq_list, parent, false);
        return new SkillAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapterViewHolder holder, int position) {
        holder.tvName.setText(mTopSkillList.get(position).getName());
        holder.tvLocation.setText(mTopSkillList.get(position).getScore() + " Learrning score, "+mTopSkillList.get(position).getCountry());


       // holder.tvName.setText(mTopSkillList.get(position).getName());
        //holder.tvLocation.setText(mTopSkillList.get(position).getIq() + " skill IQ Score, " +mTopSkillList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        if (mTopSkillList!= null) return mTopSkillList.size();
        return 0;
    }
    public class SkillAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvLocation;


        public SkillAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_skill_name);
            tvLocation = itemView.findViewById(R.id.tv_skill_location);
        }
    }
}
