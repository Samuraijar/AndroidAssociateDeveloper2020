package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.associateandroiddeveloper2020practiceproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.LearningModel;
import Model.SkillModel;

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.ViewHolder>  {
    private final Context mContext;
    private final LayoutInflater layoutInflater;
    private final List<SkillModel> mSkillModel;

    public SkillRecyclerAdapter(Context applicationContext, List<SkillModel> skillModels) {
        this.mContext = applicationContext;
        this.mSkillModel = skillModels;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.skill_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillModel skillModel = mSkillModel.get(position);
        holder.name.setText(skillModel.getName());
        holder.hours.setText(skillModel.getScore() + "  ");
        holder.country.setText(skillModel.getCountry());

        Picasso.with(mContext)
                .load(skillModel.getBadgeUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.skillBadge);


    }

    @Override
    public int getItemCount() {
        return mSkillModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView skillBadge;
        public TextView name, hours, country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            skillBadge = (ImageView) itemView.findViewById(R.id.skill_badge);
            name = (TextView) itemView.findViewById(R.id.name);
            hours = (TextView) itemView.findViewById(R.id.score);
            country = (TextView) itemView.findViewById(R.id.country);
        }
    }
}
