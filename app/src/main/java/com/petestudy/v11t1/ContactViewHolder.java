package com.petestudy.v11t1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView nameText, numberText, groupText;
    ImageButton detailsButton, deleteButton;

    public  ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.ContactNameText);
        numberText = itemView.findViewById(R.id.ContactNumberText);
        groupText = itemView.findViewById(R.id.ContactGroupText);
        detailsButton = itemView.findViewById(R.id.ContactDetailsButton);
        deleteButton = itemView.findViewById(R.id.ContactDeleteButton);
    }
}
