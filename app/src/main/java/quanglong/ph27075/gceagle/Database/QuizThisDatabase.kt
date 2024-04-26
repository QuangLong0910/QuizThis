package quanglong.ph27075.gceagle.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import quanglong.ph27075.gceagle.DAO.QuizThizDAO
import quanglong.ph27075.gceagle.Model.QuizThis
import kotlin.jvm.Volatile

@Database(entities = [QuizThis::class], version = 1)
abstract class QuizThisDatabase : RoomDatabase() {
    abstract fun getQuizThisDao(): QuizThizDAO

    companion object {
        @Volatile
        private var instance: QuizThisDatabase? = null
        fun getInstance(context: Context): QuizThisDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, QuizThisDatabase::class.java,"QuizThisDatabase")
                        .build()
            }
            return instance!!
        }


    }
}