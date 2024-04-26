package quanglong.ph27075.gceagle.FrgLogin

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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.MutableStateFlow
import quanglong.ph27075.gceagle.Activity.TrangchuActivity
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.AccountViewModel
import quanglong.ph27075.gceagle.databinding.FragmentLoginBinding


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
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            isLoggedIn.collect { loggedIn ->
                if (loggedIn) {
                    val intent = Intent(requireActivity(), TrangchuActivity::class.java)
                    startActivity(intent)
//                    isLoggedIn.value=false
                }
            }
        }

        with(binding) {
            val userName = this.edtUserName.text
            val password = this.edtPass.text
            binding.btnLogin.setOnClickListener {
                accountViewModel.getAccount(
                    userName.toString(),
                    password.toString()
                ).observe(viewLifecycleOwner) { accounts ->
                    if (accounts == null) {
                        Log.d("Sai", password.toString())
                        Toast.makeText(
                            requireContext(),
                            "Tài khoản hoặc mật khẩu không đúng.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Đăng nhập thành công, trạng thái sẽ được cập nhật trong isLoggedIn
                        isLoggedIn.value = true
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



