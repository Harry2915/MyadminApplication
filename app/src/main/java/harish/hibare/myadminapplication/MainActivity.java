package harish.hibare.myadminapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private static final String URL_Vendor = "  https://ar-application.000webhostapp.com/AR_Shopping/retrive_vendor_list.php";


    RecyclerView recyclerView;
    List<Vendor> vendorList;
    static String sts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vendorList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadVendors();
    }

    private void loadVendors() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_Vendor,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                vendorList.add(new Vendor(
                                        product.getString("organisation"),
                                        product.getString("email"),
                                        product.getString("status")

                                ));


                            }

                            //creating adapter object and setting it to recyclerview
                            VendorAdapter adapter = new VendorAdapter(MainActivity.this, vendorList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    }
