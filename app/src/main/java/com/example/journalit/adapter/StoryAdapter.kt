package com.example.journalit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.journalit.R
import com.example.journalit.model.StoryModel
import com.example.journalit.ui.activity.UpdateStoryActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class StoryAdapter(val context: Context,
    var data: ArrayList<StoryModel>): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

        class StoryViewHolder(itemView: View)
            :RecyclerView.ViewHolder(itemView){
                val imageView : ImageView = itemView.findViewById(R.id.getImage)
            val loading: ProgressBar = itemView.findViewById(R.id.progressBar2)
            val editButton : TextView = itemView.findViewById(R.id.lblEdit)
            val pName : TextView = itemView.findViewById(R.id.displayTitle)
            val pDesc : TextView = itemView.findViewById(R.id.displayDesc)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.sample_journal,parent,false)

        return StoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.pName.text = data[position].storyName
        holder.pDesc.text = data[position].storyDesc

        Picasso.get().load(data[position].imageUrl).into(holder.imageView,object: Callback {
            override fun onSuccess() {
                holder.loading.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })
        holder.editButton.setOnClickListener {
            val intent = Intent(context, UpdateStoryActivity::class.java)
//

            intent.putExtra("storyId",data[position].storyId)

            context.startActivity(intent)
        }
    }

//    fun updateData(stories: List<Storymodel>)
}









