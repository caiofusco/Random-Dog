package co.caiofusco.random_dog.api

import retrofit2.http.GET
import retrofit2.http.Path

// https://dog.ceo/

interface ServiceApi {

    @GET("")
    fun getAddress(
        @Path("message") message:String
    ): AddressResponse

}