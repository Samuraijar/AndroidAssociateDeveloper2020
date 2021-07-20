package Activities;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.associateandroiddeveloper2020practiceproject.R;

import java.util.List;

import API.RetrofitClient;
import API.Service;
import API.Service2;
import Adapters.LearningRecyclerAdapter;
import Adapters.SkillRecyclerAdapter;
import Model.LearningModel;
import Model.SkillModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillFragment extends Fragment {
    private RecyclerView recyclerView;
    private SkillModel skillModel;
    TextView disconnected;
    AlertDialog.Builder builder;
    AlertDialog dialog;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.skill_fragment, container, false);
        recyclerView = rootView.findViewById(R.id.skill_fragment_adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        setHasOptionsMenu(true);

        builder = new AlertDialog.Builder(rootView.getContext());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.alert_dialog);
        dialog = builder.create();
        dialog.show();

        loadData();

        return rootView;
    }

    private void loadData() {
        try {
            RetrofitClient client = new RetrofitClient();
            Service2 service = RetrofitClient.getClient().create(Service2.class);
            Call<List<SkillModel>> call = service.getItems();
            call.enqueue(new Callback<List<SkillModel>>() {
                @Override
                public void onResponse(Call<List<SkillModel>> call, Response<List<SkillModel>> response) {
                    List<SkillModel> skillModelList = (List<SkillModel>) response.body();
                    recyclerView.setAdapter(new SkillRecyclerAdapter(getContext(), skillModelList));
                    dialog.dismiss();

                }

                @Override
                public void onFailure(Call<List<SkillModel>> call, Throwable t) {


                }
            });
        }
        catch (Exception e) {
            Log.d("Error", e.getMessage());


        }
    }
}
