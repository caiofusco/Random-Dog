package co.caiofusco.random_dog.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// SINGLETON PARA INSTANCIAR O RETROFIT
class NetworkUtils {
    companion object {
        fun getRetrofitInstance(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}