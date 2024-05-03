package test.co.mvi.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import test.co.mvi.BaseActivity
import test.co.mvi.intent.UserIntent
import test.co.mvi.viewmodel.UserViewModel
import test.co.mvi.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: UserViewModel

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun viewInit() {
        // Implementasi untuk inisialisasi view di sini
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    override fun onClick() {
        // Implementasi untuk event klik di sini
        // Misalnya, pembaruan data dipicu oleh tombol yang ditekan
        binding.updateButton.setOnClickListener {
            viewModel.handleIntent(UserIntent.UpdateUser("John", 30))
        }

        binding.updateButtonNew.setOnClickListener {
            viewModel.handleIntent(UserIntent.UpdateUser("Agus", 27))
        }
    }

    override fun listener() {
        // Implementasi untuk listener di sini
        viewModel.userState.observe(this, Observer { user ->
            binding.nameTextView.text = user.name
            binding.ageTextView.text = user.age.toString()
        })
    }
}