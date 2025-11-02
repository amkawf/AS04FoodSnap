package pam.mobile.as04foodsnap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import pam.mobile.as04foodsnap.ui.FoodSnapFormScreen
import pam.mobile.as04foodsnap.ui.theme.AS04FoodSnapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Gunakan tema bawaan project kamu
            AS04FoodSnapTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Panggil composable utama
                    FoodSnapFormScreen()
                }
            }
        }
    }
}
