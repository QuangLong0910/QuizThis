package quanglong.ph27075.gceagle.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Adapter.QuizThisState
import quanglong.ph27075.gceagle.Model.QuizThis

import quanglong.ph27075.gceagle.Repository.QuizThisRepository
import java.lang.IllegalArgumentException

class QuizThizViewModel(application: Application) : ViewModel() {

    private val quizThisRepository: QuizThisRepository = QuizThisRepository(application)
    private val quizStateFlow: MutableStateFlow<QuizThisState> =
        MutableStateFlow(QuizThisState.Emty)
    val _quizStateFlow: StateFlow<QuizThisState> = quizStateFlow
    fun getPost() = viewModelScope.launch {
        quizStateFlow.value = QuizThisState.Loading
        getAll()
            .catch { e ->
                quizStateFlow.value = QuizThisState.Failure(e)
            }.collect { data ->
                if (data.isEmpty()) {
                    quizStateFlow.value = QuizThisState.Emty
                } else {
                    quizStateFlow.value = QuizThisState.Success(data)
                    Log.d("hello", data.toString())
                }
            }
    }

    fun insertBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.insertsBaiHoc(quizThis)
    }

    fun updateBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.updateBaiHoc(quizThis)
    }

    fun deleteBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.deleteBaiHoc(quizThis)
    }

    fun getAll(): Flow<List<QuizThis>> {
        return quizThisRepository.getAll()
    }

    class QuizThisViewmodelFactory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuizThizViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return QuizThizViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }

}