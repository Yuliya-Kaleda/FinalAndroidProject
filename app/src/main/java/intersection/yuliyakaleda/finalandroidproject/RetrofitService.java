package intersection.yuliyakaleda.finalandroidproject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RetrofitService {

  @GET("search")
  Call<RetrofitResponse> getTracks(@Query("term") String artist);
}
