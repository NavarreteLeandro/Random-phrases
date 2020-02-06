package com.example.frasesrandom.Data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "frase_table")
public class Frase {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "Frases")
    public String mFrases;

    public Frase(@NonNull String mFrases) {
        this.mFrases = mFrases;
    }

    @NonNull
    public String getFrase() {
        return mFrases;
    }

}
