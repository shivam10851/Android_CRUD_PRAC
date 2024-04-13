package com.example.crudprac.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudprac.R;
import com.example.crudprac.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //renders some content not all content for seemless user experience
    private Context context;
    private List<Contact> contactList;

//    declared above variables, constuctor created with alt+insert,
//    functions were implemented with alt+insert
    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact=contactList.get(position);
        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView contactName;
        private TextView phoneNumber;
        private ImageView contactImageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactName=itemView.findViewById(R.id.name);
            phoneNumber=itemView.findViewById(R.id.phone_number);
            contactImageButton=itemView.findViewById(R.id.pfp);
            contactImageButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d("dbTable" ,"thats some clicking!!");
        }
    }
}
