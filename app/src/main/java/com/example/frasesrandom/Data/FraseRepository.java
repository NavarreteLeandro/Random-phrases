package com.example.frasesrandom.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FraseRepository {

    private FrasesDao mFraseDao;

    private LiveData<List<Frase>> mAllFrases;

    public FraseRepository (Application application){
        FraseRoomDatabase db = FraseRoomDatabase.getDatabase(application);
        mFraseDao = db.frasesDao();
        mAllFrases = mFraseDao.getAllFrases();
    }

    public LiveData<List<Frase>> getAllFrases(){
        return mAllFrases;
    }

    public void insert(Frase frase){
        FraseRoomDatabase.databaseWriteExecutor.execute(() -> {
            mFraseDao.Insert(frase);
        });
    }
}
