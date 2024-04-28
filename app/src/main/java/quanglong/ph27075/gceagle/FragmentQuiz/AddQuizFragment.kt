package quanglong.ph27075.gceagle.FragmentQuiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentAddQuizBinding


class AddQuizFragment : Fragment() {

    private val quizThisViewModel: QuizThizViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            QuizThizViewModel.QuizThisViewmodelFactory(application)
        )[QuizThizViewModel::class.java]

    }
    private lateinit var binding: FragmentAddQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddQuizBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNewquiz.setOnClickListener {
            val quizThis = QuizThis(
                binding.edtName.text.toString(),
                binding.edtDes.text.toString(),
                binding.edtNgaytao.text.toString(),
                binding.edtNguoitao.text.toString()
            )
            quizThisViewModel.insertBaihoc(quizThis)
            findNavController().navigate(R.id.action_addquizfragment_to_homefragment)
        }


    }
}