package quanglong.ph27075.gceagle.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.Model.Account

@Dao
interface AccountDAO {
    @Insert
    suspend fun insertAccount(account: Account)

    @Update
    suspend fun updateAccount(account: Account)

    @Delete
    suspend fun deleteAccount(account: Account)

    @Query("select*from User")
    fun getAllAccount(): Flow<List<Account>>

    @Query("SELECT * FROM User WHERE Username = :userName AND Password_user = :passWord")
    fun getAccount(userName: String, passWord: String): Flow<Account>

    @Query("SELECT * FROM User WHERE Username = :userName ")
    fun getAccountUsername(userName: String): Flow<List<Account>>


}