package quanglong.ph27075.gceagle.Repository

import android.app.Application

import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.DAO.QuizThisDAO

import quanglong.ph27075.gceagle.Database.QuizThisDatabase
import quanglong.ph27075.gceagle.Model.QuizThis

class QuizThisRepository(app: Application) {


    private val quizThisDAo: QuizThisDAO

    init {
        val quizThisDatabase: QuizThisDatabase = QuizThisDatabase.getInstance(app)
        quizThisDAo = quizThisDatabase.getQuizThisDao()
    }

    suspend fun insertsBaiHoc(baiHoc: QuizThis) = quizThisDAo.insertsBai(baiHoc)
    suspend fun updateBaiHoc(baiHoc: QuizThis) = quizThisDAo.updateBai(baiHoc)
    suspend fun deleteBaiHoc(baiHoc: QuizThis) = quizThisDAo.deleteBai(baiHoc)
    fun getAll(): Flow<List<QuizThis>> {
        return quizThisDAo.getAllBaiHoc()
    }

}