package com.vilkis.test.service;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vilkis.test.database.Database;
import com.vilkis.test.model.Character;
import com.vilkis.test.utility.EndpointInterface;
import com.vilkis.test.utility.RetrofitClientInstance;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CharacterService {

    private final Context context;

    private final EndpointInterface endpointInterface = RetrofitClientInstance.getRetrofitInstance().create(EndpointInterface.class);

    public CharacterService(Context context) {
        this.context = context;
    }

    public Observable<List<Character>> getCharacters() {
        return Observable.create(emitter -> endpointInterface.listCharacters().enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(@NonNull Call<List<Character>> call, @NonNull Response<List<Character>> response) {
                if (response.body() == null) {
                    return;
                }

                List<Character> characters = response.body();

                Database database = new Database();
                database.executeTransaction(realm -> realm.insertOrUpdate(characters));
                database.close();
            }

            @Override
            public void onFailure(@NonNull Call<List<Character>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        }));
    }
}
