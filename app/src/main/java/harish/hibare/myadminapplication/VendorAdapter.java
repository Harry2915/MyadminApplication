package harish.hibare.myadminapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder> {


    private Context mCtx;
    private List<Vendor> vendorList;
    String sts;

    public VendorAdapter(Context mCtx, List<Vendor> vendorList) {
        this.mCtx = mCtx;
        this.vendorList = vendorList;
    }



    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.vendor_list, null);
        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        Vendor  vendor = vendorList.get(position);
        holder.orgname.setText(vendor.getOrganisation());
        holder.email.setText(vendor.getEmail());
        holder.status.setText(vendor.getStatus());

    }



    @Override
    public int getItemCount() {
        return vendorList.size();
    }
    static class VendorViewHolder extends RecyclerView.ViewHolder {

        TextView orgname, email;
        Button status;
//        @SuppressLint("StaticFieldLeak")


        public VendorViewHolder(View itemView) {
            super(itemView);

            orgname = itemView.findViewById(R.id.organisationname);
            email = itemView.findViewById(R.id.email);
            status = itemView.findViewById(R.id.status);
            status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId()==status.getId()){
                        status.setText("hello");
                    }

                }
            });



        }




    }
}