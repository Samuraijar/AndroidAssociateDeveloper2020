package API;

import java.util.List;

import Model.LearningModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/api/hours")
    Call<List<LearningModel>> getItems();
}
