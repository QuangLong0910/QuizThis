package quanglong.ph27075.gceagle.Repository

import android.app.Application
import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.DAO.QuestionDAO
import quanglong.ph27075.gceagle.Database.QuizThisDatabase
import quanglong.ph27075.gceagle.Model.Question
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.Model.QuizWithQuesEntities

class QuestionRepository (app:Application) {
    private val questionDao : QuestionDAO
    init {
        val questionDatabase : QuizThisDatabase = QuizThisDatabase.getInstance(app)
        questionDao = questionDatabase.getQuestionDao()
    }
    suspend fun insertsQuestion(question: Question) = questionDao.insertsQuestion(question)

    suspend fun updateQuestion(question: Question) = questionDao.updateQuestion(question)
    suspend fun deleteQuestion(question: Question) = questionDao.deleteQuestion(question)
    fun getAllQuestionId(): Flow<List<QuizWithQuesEntities>> {
        return questionDao.getQuizWithQuesEntities()
    }
}