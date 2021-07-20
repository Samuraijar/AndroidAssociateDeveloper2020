package API;

import java.util.List;

import Model.SkillModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service2 {
    @GET("/api/skilliq")
    Call<List<SkillModel>> getItems();
}
