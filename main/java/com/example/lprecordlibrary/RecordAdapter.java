package com.example.lprecordlibrary;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AlertDialog;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class RecordAdapter extends ArrayAdapter<Record>
{

    Context mCtx;
    int listLayoutRes;
    List<Record> recordList;
    SQLiteDatabase db;

    public RecordAdapter(Context mCtx, int listLayoutRes, List<Record> recordList) {
        super(mCtx, listLayoutRes, recordList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.recordList = recordList;
        this.db = db;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        Record record = recordList.get(position);


        //getting views
        TextView textViewAlbumName = view.findViewById(R.id.textViewAlbumName);
        TextView textViewArtistName = view.findViewById(R.id.textViewArtistName);
        TextView textViewLabelName = view.findViewById(R.id.textViewlabelName);
        TextView textViewYear = view.findViewById(R.id.textViewYear);
        TextView textViewOwnerName = view.findViewById(R.id.textViewownerName);
        //adding data to views
        textViewAlbumName.setText(record.getalbumName());
        textViewArtistName.setText(record.getartistName());
        textViewLabelName.setText(record.getlabelName());
        textViewYear.setText(record.getYear());
        textViewOwnerName.setText(record.getownerName());

        //we will use these buttons later for update and delete operation
        Button buttonDelete = view.findViewById(R.id.buttonDeleteRecord);
        Button buttonEdit = view.findViewById(R.id.buttonEditRecord);

        return view;
    }
}