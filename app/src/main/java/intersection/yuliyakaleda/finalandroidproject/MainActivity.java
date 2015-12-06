package intersection.yuliyakaleda.finalandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ENDPOINT = "https://itunes.apple.com/";
    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText inputET;
    private Button search;
    private ListView list;
    private RetrofitService service;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputET = (EditText) findViewById(R.id.input);
        list = (ListView) findViewById(R.id.list);
        search = (Button) findViewById(R.id.search_button);
        search.setOnClickListener(this);
        service = createRetrofitService(ENDPOINT);
    }

    private static RetrofitService createRetrofitService(String endPoint) {
        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        client.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl(endPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit.create(RetrofitService.class);
    }

    @Override
    public void onClick(View v) {
        String artist = inputET.getText().toString();
        Call<RetrofitResponse> call = service.getTracks(artist);
        call.enqueue(new retrofit.Callback<RetrofitResponse>() {
            @Override
            public void onResponse(Response<RetrofitResponse> response) {
                if(response != null) {
                    RetrofitResponse retrofitResponse = response.body();
                    List<Track> tracks = retrofitResponse.getTracks();
                    customAdapter = new CustomAdapter(MainActivity.this, R.layout.list_item,
                        tracks);
                    list.setAdapter(customAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "Retrofit: " + t.getMessage());
            }
        });
    }
}
