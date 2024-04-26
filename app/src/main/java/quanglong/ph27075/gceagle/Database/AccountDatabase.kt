package quanglong.ph27075.gceagle.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import quanglong.ph27075.gceagle.DAO.AccountDAO
import quanglong.ph27075.gceagle.Model.Account


@Database(entities = [Account::class], version = 1)
abstract class AccountDatabase : RoomDatabase() {
    abstract fun getAccountDao(): AccountDAO

    companion object {
        @Volatile
        private var instance: AccountDatabase? = null
        fun getInstance(context: Context): AccountDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, AccountDatabase::class.java, "AccountDatabase")
                        .build()
            }
            return instance!!
        }
    }

}