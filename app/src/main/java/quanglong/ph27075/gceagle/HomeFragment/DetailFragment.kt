package quanglong.ph27075.gceagle.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Adapter.AdapterRecycleview
import quanglong.ph27075.gceagle.Adapter.AdapterRecycleviewQuestion
import quanglong.ph27075.gceagle.Model.Question
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.Model.QuizWithQuesEntities
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.QuestionViewModel
import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentDetailBinding
import quanglong.ph27075.gceagle.databinding.FragmentHomeBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var quizadapter : AdapterRecycleviewQuestion
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initControls()
        lifecycleScope.launch {
            try {
                val newDataList: List<QuizWithQuesEntities> = questionViewModel.getQuestion().first() // Chuyển đổi Flow sang List
                quizadapter.setData(newDataList) // Đặt dữ liệu mới lên RecyclerView

            } catch (e: Exception) {
                // Xử lý exception nếu có
            }
        }
    }


    private val questionViewModel: QuestionViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            QuestionViewModel.QuestionViewModelFactory(application)
        )[QuestionViewModel::class.java]

    }
        private val OnItemClick: (Question,Int) -> Unit = {
                _, i ->  findNavController().navigate(R.id.action_homefragment_to_detailfragment)



        }
        private val OnItemDelete: (Question) -> Unit = {

        }
    private fun initControls() {
        quizadapter = AdapterRecycleviewQuestion(requireContext(), OnItemClick, OnItemDelete)
        binding.recycleviewquestion.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = quizadapter


        }
    }


}