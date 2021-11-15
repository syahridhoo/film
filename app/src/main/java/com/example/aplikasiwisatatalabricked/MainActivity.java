package com.example.aplikasiwisatatalabricked;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aplikasiwisatatalabricked.alarm.AlarmActivity;
import com.example.aplikasiwisatatalabricked.model.RootWisataModel;
import com.example.aplikasiwisatatalabricked.model.WisataItem;
import com.example.aplikasiwisatatalabricked.rest.ApiConfig;
import com.example.aplikasiwisatatalabricked.rest.ApiService;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private ArrayList<WisataItem> wisataItems;
    private AdapterListWisata adapterListWisatadapter;
    private RecyclerView recyclerView;
    private Text mAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        wisataItems = new ArrayList<>();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RootWisataModel>() {
            @Override
            public void onResponse(Call<RootWisataModel> call, Response<RootWisataModel> response) {
                if (response.isSuccessful()) {
                    wisataItems = response.body().getWisata();
                    adapterListWisatadapter = new AdapterListWisata(wisataItems, getApplicationContext());
                    recyclerView.setAdapter(adapterListWisatadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RootWisataModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        mAlarm= findViewById(R.id.action_alarm);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_alarm:
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                String mOrderMessage = null;
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}