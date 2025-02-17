package com.example.kokoro.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kokoro.R
import com.example.kokoro.adapter.StoryAdapter
import com.example.kokoro.model.StoryModel
import com.example.kokoro.ui.activity.AddStoryActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StoryAdapter
    private var storyList: ArrayList<StoryModel> = ArrayList() // Initialize the list

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Floating Action Button click listener to open AddStoryActivity
        val fab: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(requireContext(), AddStoryActivity::class.java)
            startActivity(intent)
        }

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        // Set adapter
        adapter = StoryAdapter(storyList)
        recyclerView.adapter = adapter

        // Load initial data or mock data
        loadStoryData()

        return view
    }

    // Function to load mock or dynamic story data
    private fun loadStoryData() {
        // Add sample data (can be fetched dynamically)
        storyList.add(StoryModel("1","Title 1", "Description 1", ))
        storyList.add(StoryModel("2","Title 2", "Description 2"))

        // Notify adapter that data has changed
        adapter.notifyDataSetChanged()
    }

    // Optionally, if you want to update the list dynamically from another source (e.g., an API or DB)
    fun updateStoryList(newStoryList: ArrayList<StoryModel>) {
        storyList.clear() // Clear the current list
        storyList.addAll(newStoryList) // Add new data
        adapter.notifyDataSetChanged() // Notify adapter to refresh the RecyclerView
    }
}
