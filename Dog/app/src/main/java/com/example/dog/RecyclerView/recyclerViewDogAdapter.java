package com.example.dog.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dog.APIModels.Breeds;
import com.example.dog.APIModels.DogDetails;
import com.example.dog.APIModels.DogID;
import com.example.dog.DetailedDogView;
import com.example.dog.R;
import com.example.dog.RetrofitHelperClass.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class recyclerViewDogAdapter extends RecyclerView.Adapter<recyclerViewDogAdapter.Breed> {
    private ArrayList<DogID> mBreedList = new ArrayList<>();
    private LayoutInflater mInfalter;
    private Context context;

    public recyclerViewDogAdapter(Context context, ArrayList<DogID> mBreedList) {
        mInfalter = LayoutInflater.from(context);
        this.context = context;
        this.mBreedList = mBreedList;
    }

    @NonNull
    @Override
    public Breed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInfalter.inflate(R.layout.breed_layout, parent, false);
        return new Breed(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull Breed holder, int position) {
        TextView textView = holder.breedView;
        String breed = mBreedList.get(position).getBreedName();
        holder.breedView.setText(breed);
    }

    @Override
    public int getItemCount() {
        return mBreedList.size();
    }

    class Breed extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView breedView;
        final recyclerViewDogAdapter mAdapter;

        public Breed(@NonNull View itemView, recyclerViewDogAdapter adapter) {
            super(itemView);
            breedView = itemView.findViewById(R.id.breedView);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(context, DetailedDogView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("REQUESTED_DOGGO_ID", mBreedList.get(mPosition).getId());
            context.startActivity(intent);

        }
    }
}
