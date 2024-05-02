package quanglong.ph27075.gceagle.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import quanglong.ph27075.gceagle.DAO.AccountDAO
import quanglong.ph27075.gceagle.Database.QuizThisDatabase
import quanglong.ph27075.gceagle.Model.Account

class AccountRepository(app: Application) {
    private val accountDao: AccountDAO

    init {
        var accountDatabase: QuizThisDatabase = QuizThisDatabase.getInstance(app)
        accountDao = accountDatabase.getAccountDao()
    }

    suspend fun insenstAccount(account: Account) = accountDao.insertAccount(account)
    suspend fun updateAccount(account: Account) = accountDao.updateAccount(account)
    suspend fun deleteAccount(account: Account) = accountDao.deleteAccount(account)
    fun getAll(): Flow<List<Account>> = accountDao.getAllAccount()
    fun getAccount(username: String, password: String): Flow<Account> {
        return accountDao.getAccount(username, password)
    }

    fun getAccountUsername(username: String): Flow<List<Account>> {
        return accountDao.getAccountUsername(username)
    }



}