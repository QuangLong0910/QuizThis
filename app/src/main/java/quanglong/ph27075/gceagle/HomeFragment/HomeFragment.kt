@file:Suppress("DEPRECATION")

package quanglong.ph27075.gceagle.HomeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.view.isVisible

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager


import quanglong.ph27075.gceagle.Adapter.AdapterRecycleview
import quanglong.ph27075.gceagle.Adapter.QuizThisState
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R

import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var quizadapter: AdapterRecycleview
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        initEvens()
        initControls()

        quizThisViewModel.getPost()
        lifecycleScope.launchWhenStarted {
            quizThisViewModel._quizStateFlow.collect {
                when (it) {
                    is QuizThisState.Loading -> {
                        binding.recy.isVisible = false
                        Log.d("Success", "203")
                    }

                    is QuizThisState.Emty -> {
                        Log.d("Success", "202")
                    }

                    is QuizThisState.Failure -> {
                        Log.d("Success", "201")
                    }

                    is QuizThisState.Success -> {
                        Log.d("Success", "200")
                        quizadapter.setData(it.data)
                        binding.recy.isVisible = true
                        quizadapter.notifyDataSetChanged()
                        Log.d("Hello", it.data.toString())


                    }


                }
            }
        }


    }

    private fun initEvens() {


    }

    private fun initControls() {
        quizadapter = AdapterRecycleview(requireContext(), OnItemClick, OnItemDelete)
        binding.recy.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = quizadapter
        }


    }


    private val OnItemClick: (QuizThis, Int) -> Unit = { _, i ->
        findNavController().navigate(R.id.action_homefragment_to_detailfragment)
        Log.d("Iddd", i.toString())


    }
    private val OnItemDelete: (QuizThis) -> Unit = {

    }
    private val quizThisViewModel: QuizThizViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            QuizThizViewModel.QuizThisViewmodelFactory(application)
        )[QuizThizViewModel::class.java]

    }


}