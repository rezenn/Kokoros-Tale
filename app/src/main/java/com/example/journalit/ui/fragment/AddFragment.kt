package com.example.journalit.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.enableSavedStateHandles
import com.example.journalit.databinding.ActivityDashboardBinding
import com.example.journalit.databinding.FragmentAddBinding
import com.example.journalit.utils.ImageUtils
import com.example.journalit.utils.LoadingUtils
import com.example.journalit.viewmodel.StoryViewModel

class AddFragment : Fragment() {

        lateinit var binding: ActivityDashboardBinding
        lateinit var storyViewModel: StoryViewModel
        lateinit var loadingUtils: LoadingUtils
        lateinit var imageUtils: ImageUtils

        var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundel?
        ): View? {
            binding = FragmentAddBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

        binding = FragmentAddBinding.inflate()
    }


}