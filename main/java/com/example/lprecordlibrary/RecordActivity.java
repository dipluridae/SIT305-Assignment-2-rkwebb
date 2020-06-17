package com.example.lprecordlibrary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {


    List<Record> recordList;
    SQLiteDatabase db;
    ListView listViewRecords;
    RecordAdapter adapter;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Toast.makeText(RecordActivity.this, "Album found in Library", Toast.LENGTH_LONG).show();
        listViewRecords = (ListView) findViewById(R.id.listViewRecords);
        recordList = new ArrayList<>();

        //opening the database
        db = openOrCreateDatabase(DatabaseHelper.DATABASE_NAME, MODE_PRIVATE, null);

        //this method will display the employees in the list
        showRecordsFromDatabase();
    }

    private void showRecordsFromDatabase() {

        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorRecords = db.rawQuery("Select * FROM albums", null);
        //Cursor cursorRecords = getRecordInformation();

        //if the cursor has some data
        if (cursorRecords.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                recordList.add(new Record(
                        cursorRecords.getInt(0),
                        cursorRecords.getString(1),
                        cursorRecords.getString(2),
                        cursorRecords.getString(3),
                        cursorRecords.getString(4),
                        cursorRecords.getString(5)
                ));
            } while (cursorRecords.moveToNext());
        }
        //closing the cursor
        cursorRecords.close();

        //creating the adapter object
        adapter = new RecordAdapter(this, R.layout.list_layout_record, recordList);

        //adding the adapter to listview
        listViewRecords.setAdapter(adapter);
    }


}