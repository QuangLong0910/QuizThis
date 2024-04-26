package quanglong.ph27075.gceagle.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Model.QuizThis

import quanglong.ph27075.gceagle.Repository.QuizThisRepository
import java.lang.IllegalArgumentException

class QuizThizViewModel(application: Application) :ViewModel(){

    private val quizThisRepository :QuizThisRepository = QuizThisRepository(application)
    fun insertBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.insertsBaiHoc(quizThis)
    }
    fun updateBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.updateBaiHoc(quizThis)
    }
    fun deleteBaihoc(quizThis: QuizThis) = viewModelScope.launch {
        quizThisRepository.deleteBaiHoc(quizThis)
    }
    fun getAll():Flow<List<QuizThis>> = quizThisRepository.getAll()

    class BaihocViewmodelFactory(private val application: Application):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
           if(modelClass.isAssignableFrom(QuizThizViewModel::class.java)){
               @Suppress("UNCHECKED_CAST")
               return QuizThizViewModel(application) as T
           }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }

}