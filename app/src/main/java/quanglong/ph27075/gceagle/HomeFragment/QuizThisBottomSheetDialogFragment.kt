package quanglong.ph27075.gceagle.HomeFragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.QuizThizViewModel
import quanglong.ph27075.gceagle.databinding.FragmentAddQuizBinding
import java.time.LocalDateTime

class QuizThisBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAddQuizBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetBehavior = (dialog as BottomSheetDialog).behavior
        bottomSheetBehavior.peekHeight = resources.getDimensionPixelSize(R.dimen.peek_height)


        bottomSheetBehavior.expandedOffset = resources.getDimensionPixelSize(R.dimen.expanded_offset)

        binding.btnNewquiz.setOnClickListener {
            val time = getCurrentDateTime()
            val create  = "ADMIN"
            val quizThis = QuizThis(
                binding.edtName.text.toString(),
                binding.edtDes.text.toString(),
                time.toString(),create,false
            )
            quizThisViewModel.insertBaihoc(quizThis)

            dismiss()
        }

    }
    private val quizThisViewModel: QuizThizViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            QuizThizViewModel.QuizThisViewmodelFactory(application)
        )[QuizThizViewModel::class.java]

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentDateTime(): LocalDateTime {
        return LocalDateTime.now()
    }

}