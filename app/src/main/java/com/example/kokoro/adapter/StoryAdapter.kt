package com.example.kokoro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kokoro.R
import com.example.kokoro.model.StoryModel

class StoryAdapter(private val storyList: ArrayList<StoryModel>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.displayTitle)
        val desc: TextView = itemView.findViewById(R.id.displayDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storyList[position]
        holder.title.text = story.storyTitle
        holder.desc.text = story.storyDesc
    }

    override fun getItemCount(): Int = storyList.size

    // Method to update the list dynamically
    fun updateList(newList: ArrayList<StoryModel>) {
        storyList.clear()
        storyList.addAll(newList)
        notifyDataSetChanged()
    }
}
