package quanglong.ph27075.gceagle.FrgReg

import android.os.Build
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import quanglong.ph27075.gceagle.Model.Account
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.ViewModel.AccountViewModel
import quanglong.ph27075.gceagle.databinding.FragmentRegBinding
import java.time.LocalDateTime
import java.util.regex.Pattern

@RequiresApi(Build.VERSION_CODES.O)
class RegFragment : Fragment() {

    private lateinit var binding: FragmentRegBinding
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
        binding = FragmentRegBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRigistration.setOnClickListener {
            accountViewModel.getAll().observe(viewLifecycleOwner) { accounts ->
                val isAdmin = accounts.isEmpty()
                val isActive = true
                if (checkEmailvaluedate()) {
                    val userName = binding.edtNewuser.text
                    val password = binding.edtNewpass.text
                    val fullname = binding.edtFullname.text

                    if (binding.edtNewuser.text.toString()
                            .isEmpty() || userName.toString()
                            .isEmpty() || password.toString().isEmpty()
                    ) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.msg_please_enter_info),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (password.toString().length < 8) {
                        Toast.makeText(
                            requireContext(),
                            "Vui lòng điền mật khẩu trên 8 kí tự",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val time = getCurrentDateTime()
                        val account = Account(
                            userName.toString(),
                            password.toString(),
                            fullname.toString(),
                            time.toString(), isAdmin, isActive
                        )
                        accountViewModel.insertAccount(account)
                        findNavController().navigate(R.id.action_frgreg_to_frglogin)
                    }
                }

            }
        }
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun checkEmailvaluedate(): Boolean {
        val email = binding.edtNewuser.text.toString()
        if (isEmailValid(email)) {
            Toast.makeText(requireContext(), "Định dạng email đúng ", Toast.LENGTH_SHORT)
                .show()
            return true
        } else {
            Toast.makeText(requireContext(), "Email không đúng định dạng", Toast.LENGTH_SHORT)
                .show()
            return false
        }
    }


    private fun getCurrentDateTime(): LocalDateTime {
        return LocalDateTime.now()
    }
}
