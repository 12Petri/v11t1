package com.petestudy.v11t1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<Contact> contacts;

    public ContactAdapter() {
        this.contacts = ContactStorage.getInstance().getContacts();
    }

    public  ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.nameText.setText(contact.getFullName());
        holder.numberText.setText(contact.getNumber());
        holder.groupText.setText(contact.getContactGroup());

        holder.numberText.setVisibility(View.GONE);
        holder.groupText.setVisibility(View.GONE);

        holder.detailsButton.setOnClickListener(v -> {
            if (holder.numberText.getVisibility() == View.VISIBLE) {
                holder.numberText.setVisibility(View.GONE);
                holder.groupText.setVisibility(View.GONE);
            }
            else  {
                holder.numberText.setVisibility(View.VISIBLE);
                holder.groupText.setVisibility(View.VISIBLE);
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                ContactStorage.getInstance().removeContact(currentPosition);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  contacts.size();
    }
}
