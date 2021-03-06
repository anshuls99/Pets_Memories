package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView petName= (TextView) view.findViewById(R.id.name);
        TextView summary= (TextView) view.findViewById(R.id.summary);

        int nameColoumnIndex=cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColoumnIndex=cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String name=cursor.getString(nameColoumnIndex);
        String breed=cursor.getString(breedColoumnIndex);

        if (TextUtils.isEmpty(breed)) {
            breed = context.getString(R.string.unknown_breed);
        }

        petName.setText(name);
        summary.setText(breed);

    }
}