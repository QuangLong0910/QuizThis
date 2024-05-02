package quanglong.ph27075.gceagle.FragmentUser

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import quanglong.ph27075.gceagle.Activity.HomeActivity

import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.AccountViewModel
import quanglong.ph27075.gceagle.databinding.FragmentLoginBinding


@Suppress("DEPRECATION")
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    val isLoggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val accountViewModel: AccountViewModel by lazy {
        val application = requireActivity().application
        ViewModelProvider(
            this,
            AccountViewModel.AccountViewModelFactory(application)
        )[AccountViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            isLoggedIn.collect { loggedIn ->
                if (loggedIn) {
                    isLoggedIn.value=false
                }
            }
        }

        with(binding) {
            val userName = this.edtUserName.text
            val password = this.edtPass.text
            binding.btnLogin.setOnClickListener {



// Log trước khi bắt đầu quan sát
                Log.d("MyApp", "Bắt đầu quan sát Flow")

                lifecycleScope.launch {


                             accountViewModel.getAccount(userName.toString(), password.toString())
                                 .collect { account ->

                                      if(account != null) {
                                          Log.d(
                                              "MyApp",
                                              "Tài khoản không null, isAdmin = ${account.isadmin}"
                                          )
//                                          val isAdmin = account.isadmin

                                          val intent = Intent(requireContext(), HomeActivity::class.java)
                                          intent.putExtra("isAdmin", account)
                                          startActivity(intent)
                                      } else {
                                          Toast.makeText(
                                              requireContext(),
                                              "Tài khoản hoặc mật khẩu không đúng ",
                                              Toast.LENGTH_SHORT
                                          ).show()
                                      }
                                     // Log khi tài khoản không null và isAdmin được trích xuất





                                     // Log khi dữ liệu thay đổi và onChanged được gọi

                                 }



                }


            }

            binding.tvReg.setOnClickListener {
                findNavController().navigate(R.id.action_frglogin_to_frgreg)
                Log.d("Hello", "djhgfsgkjbh")
            }
        }
    }

}



