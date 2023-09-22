package co.caiofusco.random_dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import co.caiofusco.random_dog.databinding.ActivityMainBinding
import co.caiofusco.random_dog.api.EndPoint
import co.caiofusco.random_dog.util.NetworkUtils
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonNewDog.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_dog) {

            val retrofitClient = NetworkUtils.getRetrofitInstance("https://dog.ceo/")
            val endpoint = retrofitClient.create(EndPoint::class.java)

            endpoint.getDog().enqueue(object : retrofit2.Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                    val imageView: ImageView = binding.imageDog
                    val imageURL = response.body()?.get("message").toString()

                    Picasso.with(this@MainActivity).load(imageURL).into(imageView)

                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    println("Falha!")
                }

            })

        }
    }

}