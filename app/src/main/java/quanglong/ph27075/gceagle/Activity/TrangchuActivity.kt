package quanglong.ph27075.gceagle.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import quanglong.ph27075.gceagle.R
import quanglong.ph27075.gceagle.databinding.ActivityMainBinding
import quanglong.ph27075.gceagle.databinding.ActivityTrangchuBinding

class TrangchuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrangchuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrangchuBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }
}