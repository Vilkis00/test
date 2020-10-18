package com.vilkis.test.utility;

import com.vilkis.test.model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {

    @GET("api/characters")
    Call<List<Character>> listCharacters();
}
