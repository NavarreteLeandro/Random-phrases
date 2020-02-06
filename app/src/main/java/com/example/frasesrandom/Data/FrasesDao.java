package com.example.frasesrandom.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FrasesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void Insert(Frase frase);

    @Query("SELECT * FROM frase_table")
    public LiveData<List<Frase>> getAllFrases();

    @Query("DELETE FROM frase_table")
    public void deleteAll();
}
