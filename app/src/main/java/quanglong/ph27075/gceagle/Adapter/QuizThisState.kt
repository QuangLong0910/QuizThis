package quanglong.ph27075.gceagle.Adapter

import quanglong.ph27075.gceagle.Model.QuizThis

sealed class QuizThisState {
    data object Loading : QuizThisState()
    class Failure(val msg:Throwable):QuizThisState()
    class Success(val data:List<QuizThis>):QuizThisState()
    data object Emty:QuizThisState()

}

