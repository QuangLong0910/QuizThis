package quanglong.ph27075.gceagle.HomeFragment

import android.os.Bundle


import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Adapter.AdapterRecycleview
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R

import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentEditQuizThisBinding



class EditQuizThisFragment : Fragment() {
    private lateinit var binding: FragmentEditQuizThisBinding
    private lateinit var quizadapter : AdapterRecycleview


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditQuizThisBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControls()

        binding.newQuizThis.setOnClickListener{
            val bottomSheetDialogFragment = QuizThisBottomSheetDialogFragment()
            bottomSheetDialogFragment.show(childFragmentManager, bottomSheetDialogFragment.tag)

        }




    }
    private fun initControls() {

        quizadapter  = AdapterRecycleview(requireContext(), OnItemClick, OnItemDelete)
        binding.recynewquizpinned.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(requireContext())
            adapter = quizadapter


        }
        lifecycleScope.launch {
            try {
                val newDataList: List<QuizThis> = quizThisViewModel.getAll().first() // Chuyển đổi Flow sang List
                quizadapter.setData(newDataList) // Đặt dữ liệu mới lên RecyclerView

            } catch (e: Exception) {
                // Xử lý exception nếu có
            }
        }



    }
    private val OnItemClick: (QuizThis,Int) -> Unit = {
            _, _ ->  findNavController().navigate(R.id.action_editQuizThisFragment_to_detailfragment)

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