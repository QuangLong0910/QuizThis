package quanglong.ph27075.gceagle.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import quanglong.ph27075.gceagle.Model.Account
import quanglong.ph27075.gceagle.Repository.AccountRepository
import java.lang.IllegalArgumentException

class AccountViewModel(application: Application) : ViewModel() {
    private val accountRepository: AccountRepository = AccountRepository(application)
    fun insertAccount(account: Account) = viewModelScope.launch {
        accountRepository.insenstAccount(account)
    }

    fun updateAccount(account: Account) = viewModelScope.launch {
        accountRepository.updateAccount(account)
    }

    fun deleteAccount(account: Account) = viewModelScope.launch {
        accountRepository.deleteAccount(account)
    }

    fun getAll(): Flow<List<Account>> {
        return accountRepository.getAll()
    }

    fun getAccount(username: String, password: String): Flow<Account> {
        return accountRepository.getAccount(username, password)
    }

    fun getAccountUsername(username: String): Flow<List<Account>> {
        return accountRepository.getAccountUsername(username)
    }

    class AccountViewModelFactory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AccountViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }

    }


}