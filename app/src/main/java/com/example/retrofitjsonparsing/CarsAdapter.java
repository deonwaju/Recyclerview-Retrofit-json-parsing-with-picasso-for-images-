package com.example.retrofitjsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private Context context;
    private ArrayList<CarModels> carModels = new ArrayList<>();

    public CarsAdapter(Context context, ArrayList<CarModels> carModels) {
        this.context = context;
        this.carModels = carModels;
    }

    @NonNull
    @Override
    public CarsAdapter.CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cars, parent, false);

        return new CarsAdapter.CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.CarsViewHolder holder, int position) {

        holder.carName.setText(carModels.get(position).getName());
        holder.carDescription.setText(carModels.get(position).getDesc());

        Picasso.get().load(carModels.get(position).getImage()).into(holder.carImage);
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {

        private TextView carName;
        private TextView carDescription;
        private ImageView carImage;

        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);

            carName = itemView.findViewById(R.id.car_name);
            carDescription = itemView.findViewById(R.id.car_descriptn);
            carImage = itemView.findViewById(R.id.car_img);
        }
    }
}
