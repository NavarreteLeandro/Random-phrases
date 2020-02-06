package com.example.frasesrandom.Data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Frase.class}, version = 1, exportSchema = false)
public abstract class FraseRoomDatabase extends RoomDatabase {

    public abstract FrasesDao frasesDao();

    private static volatile FraseRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FraseRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (FraseRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),FraseRoomDatabase.class, "frase_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                FrasesDao dao = INSTANCE.frasesDao();
                dao.deleteAll();

                Frase frase = new Frase("El que se fue a la villa, perdió su silla");
                dao.Insert(frase);
                frase = new Frase("Cocodrilo que se duerme, es cartera");
                dao.Insert(frase);
                frase = new Frase("A caballo regalado, no se le miran los dientes");
                dao.Insert(frase);
            });
        }
    };
}
