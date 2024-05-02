package quanglong.ph27075.gceagle.Activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import quanglong.ph27075.gceagle.HomeFragment.EditQuizThisFragment
import quanglong.ph27075.gceagle.HomeFragment.HomeFragment
import quanglong.ph27075.gceagle.HomeFragment.ProfileFragment
import quanglong.ph27075.gceagle.HomeFragment.StorageFragment

import quanglong.ph27075.gceagle.databinding.ActivityTrangchuBinding
import quanglong.ph27075.gceagle.R

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrangchuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrangchuBinding.inflate(layoutInflater)
        val isAdmin = intent.getBooleanExtra("isAdmin", false)
        if(isAdmin){
            val menuItem = binding.bottomNavigationView.menu.findItem(R.id.newQuiz)
            // Đặt thuộc tính isVisible của MenuItem thành true để hiển thị nó
            menuItem.isVisible = true
        }
        setContentView(binding.root)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home -> {
                    // Xử lý khi click vào mục "Home"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, HomeFragment()).commit()
                    return@OnNavigationItemSelectedListener true

                }


                R.id.storage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, StorageFragment())
                        .commit() // Xử lý khi click vào mục "Dashboard"
                    return@OnNavigationItemSelectedListener true
                }


                R.id.newQuiz -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, EditQuizThisFragment())
                        .commit() // Xử lý khi click vào mục "Dashboard"
                    return@OnNavigationItemSelectedListener true
                }               // Xử lý khi click vào mục "Notifications"

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ProfileFragment())
                        .commit() // Xử lý khi click vào mục "Dashboard"
                    return@OnNavigationItemSelectedListener true
                }             // Xử lý khi click vào mục "Notifications"

            }
            false
        })

    }



}