package quanglong.ph27075.gceagle.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import quanglong.ph27075.gceagle.DAO.AccountDAO
import quanglong.ph27075.gceagle.DAO.QuestionDAO
import quanglong.ph27075.gceagle.DAO.QuizThisDAO

import quanglong.ph27075.gceagle.Model.Account
import quanglong.ph27075.gceagle.Model.Question
import quanglong.ph27075.gceagle.Model.QuizThis
import kotlin.jvm.Volatile

@Database(entities = [QuizThis::class, Account::class, Question::class], version = 1)
abstract class QuizThisDatabase : RoomDatabase() {
    abstract fun getQuizThisDao(): QuizThisDAO
    abstract fun getAccountDao(): AccountDAO
    abstract fun getQuestionDao(): QuestionDAO

    companion object {
        @Volatile
        private var instance: QuizThisDatabase? = null
        fun getInstance(context: Context): QuizThisDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, QuizThisDatabase::class.java, "QuizThisDatabase")
                        .build()
            }
            return instance!!
        }


    }
}