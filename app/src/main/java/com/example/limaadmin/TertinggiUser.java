package com.example.limaadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TertinggiUser extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TertinggiUserAdapter mTertinggiUserAdapter;
    private ArrayList<TertinggiUserItem> mTertinggiUserList;
    private RequestQueue mRequestQueue;

    private String sprintid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sprintid = getIntent().getStringExtra("sprint");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tertinggi_user);

        mRecyclerView = findViewById(R.id.recycler_view1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTertinggiUserList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON(){
        final String url = "http://10.0.2.2/api/absence_logs.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray s = response.getJSONArray("data");

                            for (int i = 0; i < s.length(); i++) {
                                JSONObject sprints = s.getJSONObject(i);
                                String sprint_id = sprints.getString("sprint_id");
                                if(sprint_id.equals(sprintid)){
                                    String kelompok = sprints.getString("kelompok");
                                    String nama = sprints.getString("user_name");
                                    String sprint = String.format("Sprint %s", sprint_id);
                                    String jam_mulai = sprints.getString("jam_mulai");
                                    String jam_akhir = sprints.getString("jam_akhir");
                                    String nilai = sprints.getString("nilai");

                                    mTertinggiUserList.add(new TertinggiUserItem(kelompok, nama, sprint, jam_mulai, jam_akhir, nilai));
                                }
                            }

                            mTertinggiUserAdapter = new TertinggiUserAdapter(TertinggiUser.this, mTertinggiUserList);
                            mRecyclerView.setAdapter(mTertinggiUserAdapter);

                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
