// FoodSnapFormScreen.kt
package pam.mobile.as04foodsnap.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodsnapform.viewmodel.FoodSnapViewModel

@Composable
fun FoodSnapFormScreen(viewModel: FoodSnapViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("FoodSnap Form", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = uiState.firstName,
            onValueChange = { viewModel.updateFirstName(it) },
            label = { Text("Nama Depan") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.lastName,
            onValueChange = { viewModel.updateLastName(it) },
            label = { Text("Nama Belakang") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.foodName,
            onValueChange = { viewModel.updateFoodName(it) },
            label = { Text("Nama Makanan") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.calories,
            onValueChange = { viewModel.updateCalories(it) },
            label = { Text("Kalori") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.submitData() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        if (uiState.errorMessage.isNotEmpty()) {
            Text(uiState.errorMessage, color = MaterialTheme.colorScheme.error)
        }

        if (uiState.resultText.isNotEmpty()) {
            Text(uiState.resultText)
        }
    }
}
