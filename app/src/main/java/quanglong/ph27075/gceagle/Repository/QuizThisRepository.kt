package quanglong.ph27075.gceagle.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.DAO.QuizThizDAO
import quanglong.ph27075.gceagle.Database.QuizThisDatabase
import quanglong.ph27075.gceagle.Model.QuizThis

class QuizThisRepository(app: Application) {


    private val quiizThisDAo: QuizThizDAO

    init {
        var quizThisDatabase: QuizThisDatabase = QuizThisDatabase.getInstance(app)
        quiizThisDAo = quizThisDatabase.getQuizThisDao()
    }

    suspend fun insertsBaiHoc(baiHoc: QuizThis) = quiizThisDAo.insertsBai(baiHoc)
    suspend fun updateBaiHoc(baiHoc: QuizThis) = quiizThisDAo.updateBai(baiHoc)
    suspend fun deleteBaiHoc(baiHoc: QuizThis) = quiizThisDAo.deleteBai(baiHoc)
    fun getAll(): Flow<List<QuizThis>> {
      return  quiizThisDAo.getAllBaiHoc()
    }

}