package com.example.shimmerlayoutusingkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmerlayoutusingkotlin.model.Item
import com.squareup.picasso.Picasso

class MyRecyclerAdapter(private val context: Context, private val items: List<Item>) : RecyclerView.Adapter<MyRecyclerAdapter.MyAdapterViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyAdapterViewHolder {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.recycler_child_layout, viewGroup, false)
        return MyAdapterViewHolder(view)
    }

    override fun onBindViewHolder(myAdapterViewHolder: MyAdapterViewHolder, position: Int) {
        val title = items[position].name
        val images = items[position].image
        val season = items[position].season
        myAdapterViewHolder.itemName.setText(title)
        myAdapterViewHolder.seasonName.setText(season)
        Picasso.get().load(images).into(myAdapterViewHolder.itemIcon) // use picasso image library
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemIcon: ImageView
        var itemName: TextView
        var seasonName: TextView

        init {
            itemIcon = itemView.findViewById(R.id.imageView)
            itemName = itemView.findViewById(R.id.text)
            seasonName = itemView.findViewById(R.id.text2)
        }
    }
}
