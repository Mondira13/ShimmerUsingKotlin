package com.example.shimmerlayoutusingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shimmerlayoutusingkotlin.model.Item
import com.example.shimmerlayoutusingkotlin.response.MainResponse
import com.example.shimmerlayoutusingkotlin.sdk.APIClient
import com.example.shimmerlayoutusingkotlin.sdk.APIInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: APIInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startShimmerAnnimation()
        getListValues()
    }

   private fun getListValues() {
        apiInterface = APIClient.getClient().create(APIInterface::class.java)
        val call1 = apiInterface.getDashboardItems()
        call1.enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                if (response.isSuccessful()) {
                    if(response.body()?.result.equals("success",true)){
                        Handler().postDelayed({
                            stopShimmerAnnimation()
                            addRecyclerView(response.body())
                        }, 5000)
                    }else{
                        startShimmerAnnimation();
                    }
                }
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                call.cancel()
            }
        })
    }

    private fun addRecyclerView(body: MainResponse?) {
        if (body != null) {
            if (body.items != null) {
                recyclerView.setLayoutManager(LinearLayoutManager(this))
                val dashboardRecyclerAdapter = MyRecyclerAdapter(this@MainActivity, body.items as List<Item>)
                recyclerView.setAdapter(dashboardRecyclerAdapter)
            }
        }
    }

    private fun startShimmerAnnimation() {
        shimmerLayout.startShimmer()
        shimmerLayout.setVisibility(View.VISIBLE)
        recyclerView.setVisibility(View.GONE)
    }

    private fun stopShimmerAnnimation() {
        shimmerLayout.stopShimmer()
        shimmerLayout.setVisibility(View.GONE)
        recyclerView.setVisibility(View.VISIBLE)
    }

}

