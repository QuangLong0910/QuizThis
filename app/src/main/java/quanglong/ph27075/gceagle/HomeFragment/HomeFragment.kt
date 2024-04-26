package quanglong.ph27075.gceagle.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Adapter.AdapterRecycleview
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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


        initControls()
        initEvens()


    }

    private fun initEvens() {
        binding.them.setOnClickListener {
            findNavController().navigate(R.id.action_homefragment_to_addquizfragment)
        }

    }

    private fun initControls() {
        val adapter: AdapterRecycleview = AdapterRecycleview(requireContext(), OnItemClick, OnItemDelete)
        binding.recy.setHasFixedSize(true)
        binding.recy.layoutManager = LinearLayoutManager(requireContext())
        binding.recy.adapter = adapter
//        quizThisModel.getAll().observe(requireActivity(), Observer {
//            adapter.setBaiHoc(it)
//        })
        lifecycleScope.launch{
            quizThisModel.getAll().collect{
                list ->
                run {
                    adapter.setBaiHoc(list)
                }
            }
        }



    }

    private val OnItemClick: (QuizThis) -> Unit = {

    }
    private val OnItemDelete: (QuizThis) -> Unit = {

    }
    private val quizThisModel: QuizThizViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            QuizThizViewModel.BaihocViewmodelFactory(application)
        )[QuizThizViewModel::class.java]

    }


}