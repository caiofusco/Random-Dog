package co.caiofusco.random_dog.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("/api/breeds/image/random")
    fun getDog() : Call<JsonObject>

}