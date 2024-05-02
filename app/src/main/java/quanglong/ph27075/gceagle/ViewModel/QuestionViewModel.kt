package quanglong.ph27075.gceagle.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Model.Account
import quanglong.ph27075.gceagle.Model.Question
import quanglong.ph27075.gceagle.Model.QuizWithQuesEntities
import quanglong.ph27075.gceagle.Repository.QuestionRepository
import java.lang.IllegalArgumentException

class QuestionViewModel(application: Application) : ViewModel() {
    private val questionRepository: QuestionRepository = QuestionRepository(application)
    fun insertQuestion(question: Question) = viewModelScope.launch {
        questionRepository.insertsQuestion(question)
    }

    fun updateQuestion(question: Question) = viewModelScope.launch {
        questionRepository.updateQuestion(question)
    }

    fun deleteQuestion(question: Question) = viewModelScope.launch {
        questionRepository.deleteQuestion(question)
    }

    fun getQuestion(): Flow<List<QuizWithQuesEntities>> {
        return questionRepository.getAllQuestionId()
    }



    class QuestionViewModelFactory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return QuestionViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")

        }
    }
}