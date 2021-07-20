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

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder>  {
    private final Context mContext;
    private final LayoutInflater layoutInflater;
    private final List<LearningModel> mLearningModel;

    public LearningRecyclerAdapter(Context applicationContext, List<LearningModel> learningModels) {
        this.mContext = applicationContext;
        this.mLearningModel = learningModels;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.learning_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningModel learningModel = mLearningModel.get(position);
        holder.name.setText(learningModel.getName());
        holder.hours.setText(learningModel.getHours() + " learning hours ");
        holder.country.setText(learningModel.getCountry());

        Picasso.with(mContext)
                .load(learningModel.getBadgeUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.learningBadge);


    }

    @Override
    public int getItemCount() {
        return mLearningModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView learningBadge;
        public TextView name, hours, country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            learningBadge = (ImageView) itemView.findViewById(R.id.leaning_badge);
            name = (TextView) itemView.findViewById(R.id.learner);
            hours = (TextView) itemView.findViewById(R.id.learning_hours);
            country = (TextView) itemView.findViewById(R.id.country);
        }
    }
}
