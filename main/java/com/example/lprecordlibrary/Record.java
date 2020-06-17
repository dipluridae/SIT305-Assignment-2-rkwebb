package com.example.lprecordlibrary;

import android.widget.TextView;

public class Record
{
    long id;
    String albumName;
    String artistName;
    String labelName;
    String year;
    String ownerName;

    public Record (long id, String albumName, String artistName, String labelName, String year, String ownerName)
    {
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.labelName = labelName;
        this.year = year;
        this.ownerName = ownerName;
    }

    public long getId() {
        return id;
    }

    public String getalbumName() {
        return albumName;
    }

    public String getartistName() {
        return artistName;
    }

    public String getlabelName() {
        return labelName;
    }

    public String getYear() {
        return year;
    }

    public String getownerName() {
        return ownerName;
    }
}

