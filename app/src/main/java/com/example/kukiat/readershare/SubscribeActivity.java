package com.example.kukiat.readershare;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kukiat on 11/12/2017 AD.
 */

public class SubscribeActivity extends AppCompatActivity {

    private FirebaseUser user;
    private TextView vProfileName;
    private TextView vProfileEmail;
    private ImageView vProfileImage;
    private TextView vProfileSlogan;
    private ImageButton vProfileSubscribe;
    private ImageButton vImageButton;
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    ProgressDialog dialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        Bundle bundle = getIntent().getExtras();
//        dialog = ProgressDialog.show(SubscribeActivity.this, "","Loading. Please wait...", true);
        if(bundle!=null) {
            String uid = bundle.getString("uid");
            Log.i("uid", uid);

        }
    }

    public void fetchDataSubscribe(final String uid) throws JSONException {
        recyclerView = (RecyclerView) findViewById(R.id.subscribe_list_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<SubscribeItem> subscribeItemList = new ArrayList<>();

        String url = "https://readershare.herokuapp.com/getSubscribe/";

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        vProfileName = (TextView) findViewById(R.id.profile_name);
//                        vProfileEmail = (TextView) findViewById(R.id.profile_email);
//                        vProfileImage = (ImageView) findViewById(R.id.profile_image);
//                        vProfileSlogan = (TextView) findViewById(R.id.profile_slogan);
//                        vImageButton = (ImageButton) findViewById(R.id.subscribe_btn);
//                        vImageButton.setImageResource(R.drawable.ic_star_black_18dp);
//                        fetchSubscribe(uid);
//                        try {
//                            JSONObject profile = response.getJSONObject("profile");
//                            JSONArray post = response.getJSONArray("posts");
//
//                            String name = profile.getString("name");
//                            String email = profile.getString("email");
//                            String image = profile.getString("image");
//
//                            dialog.dismiss();
//                            vProfileEmail.setText(email);
//                            vProfileSlogan.setText("Liverpool is The BEST. YNWA");
//                            if(name.isEmpty())
//                                vProfileName.setText(email);
//                            else
//                                vProfileName.setText(name);
//                            if(image.isEmpty())
//                                Picasso.with(getApplicationContext()).load("https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg").into(vProfileImage);
//                            else
//                                Picasso.with(getApplicationContext()).load(image).into(vProfileImage);
//
//                            for(int i=0; i<post.length();i++) {
//                                JSONObject res = post.getJSONObject(i);
//
//                                String postId = res.getString("id");
//                                int timeStamp = res.getInt("createdAt");
//
//                                JSONObject book = res.getJSONObject("book");
//                                String bookImage = book.getString("image");
//
//                                JSONObject review = res.getJSONObject("review");
//                                String reviewTitle = review.getString("title");
//
//                                JSONObject reviewer = res.getJSONObject("reviewer");
//                                String reviewerId = reviewer.getString("id");
//
//                                ReleaseItem releaseItem = new ReleaseItem(postId, bookImage, reviewerId, reviewTitle, timeStamp);
//                                releaseItemList.add(releaseItem);
//                                adapter = new ReleaseAdapter(releaseItemList, getApplicationContext());
//                                recyclerView.setAdapter(adapter);
//
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError err){
//
//                    }
//                });
//        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

}
