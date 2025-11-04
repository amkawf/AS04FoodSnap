package pam.mobile.as04foodsnap.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pam.mobile.as04foodsnap.viewmodel.FoodSnapViewModel
import androidx.compose.foundation.verticalScroll


@Composable
fun FoodSnapFormScreen(viewModel: FoodSnapViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Form Data Makanan", style = MaterialTheme.typography.titleLarge)

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
            label = { Text("Kalori (kcal)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.submitData() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        // Menampilkan error validasi
        if (uiState.errorMessage.isNotEmpty()) {
            Text(
                text = uiState.errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        // Menampilkan hasil gabungan data
        if (uiState.resultText.isNotEmpty()) {
            Text(text = uiState.resultText)
        }
    }
}
