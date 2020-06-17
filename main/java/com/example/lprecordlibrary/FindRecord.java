package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

public class FindRecord extends AppCompatActivity
{
    DatabaseHelper db;
    //private ListView albums;
    //String albumFound;
   // String artistFound;
    //String labelFound;
   // String yearFound;
   // String ownerFound;

    //public void DisplayRecordText(String albumFound, String artistFound, String labelFound, String yearFound, String ownerFound) {

//DatabaseHelper db;



   // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_record);


        final EditText searchAlbumNameEditText = findViewById(R.id.searchAlbumNameEditText);
        final EditText searchArtistNameEditText = findViewById(R.id.searchArtistNameEditText);
        Button searchAlbumButton = findViewById(R.id.searchAlbumButton);

        db = new DatabaseHelper(this);

        searchAlbumButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // uses method from DatabaseHelper
                boolean result = db.fetchAlbum(searchAlbumNameEditText.getText().toString(), searchArtistNameEditText.getText().toString());
                if (result) {
                Toast.makeText(FindRecord.this, "Album found in Library", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FindRecord.this, "Album not found in Library", Toast.LENGTH_LONG).show();
                }
        }

        });


        }

}