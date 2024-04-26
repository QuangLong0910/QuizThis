package quanglong.ph27075.gceagle.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import quanglong.ph27075.gceagle.Model.QuizThis
import  kotlinx.coroutines.flow.Flow

@Dao
interface QuizThizDAO {
    @Insert
    suspend fun insertsBai(quizThis: QuizThis)

    @Update
    suspend fun updateBai(quizThis: QuizThis)

    @Delete
    suspend fun deleteBai(quizThis: QuizThis)

    @Query("select*from QuizThiz")
    fun getAllBaiHoc(): Flow<List<QuizThis>>

    @Query("select*from QuizThiz where Title=:title")
    fun getBaiHoc(title: String): LiveData<List<QuizThis>>
}