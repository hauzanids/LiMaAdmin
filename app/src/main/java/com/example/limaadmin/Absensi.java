package com.example.limaadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Absensi extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SprintAdapter mSprintAdapter;
    private ArrayList<SprintItem> mSprintList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSprintList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON(){
        final String url = "http://10.0.2.2/api/kelompok_terbaik.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray s = response.getJSONArray("data");

                            for (int i = 0; i < s.length(); i++) {
                                JSONObject sprints = s.getJSONObject(i);
                                String kelompok = sprints.getString("kelompok");
                                String sprint_id = sprints.getString("sprint_id");
                                String tanggal = sprints.getString("tanggal");
                                String sprint = String.format("Sprint %s", sprint_id);

                                mSprintList.add(new SprintItem(sprint, tanggal, kelompok));
                            }

                            mSprintAdapter = new SprintAdapter(Absensi.this, mSprintList);
                            mRecyclerView.setAdapter(mSprintAdapter);

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