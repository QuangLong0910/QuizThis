package quanglong.ph27075.gceagle.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.Model.Question
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.Model.QuizWithQuesEntities
@Dao
interface QuestionDAO {
    @Insert
    suspend fun insertsQuestion(question: Question)
    @Update
    suspend fun updateQuestion(question: Question)
    @Delete
    suspend fun deleteQuestion(question: Question)
    @Transaction
    @Query("SELECT * FROM QuizThiz")
    fun getQuizWithQuesEntities(): Flow<List<QuizWithQuesEntities>>
}