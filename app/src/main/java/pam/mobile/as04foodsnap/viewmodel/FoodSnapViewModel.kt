package pam.mobile.as04foodsnap.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import pam.mobile.as04foodsnap.model.FoodFormState

class FoodSnapViewModel : ViewModel() {

    // Menyimpan UI state
    private val _uiState = MutableStateFlow(FoodFormState())
    val uiState: StateFlow<FoodFormState> = _uiState

    // Fungsi update setiap field
    fun updateFirstName(value: String) {
        _uiState.update { it.copy(firstName = value) }
    }

    fun updateLastName(value: String) {
        _uiState.update { it.copy(lastName = value) }
    }

    fun updateFoodName(value: String) {
        _uiState.update { it.copy(foodName = value) }
    }

    fun updateCalories(value: String) {
        _uiState.update { it.copy(calories = value) }
    }

    // 🔎 Fungsi validasi input dan proses submit
    fun submitData() {
        val state = _uiState.value

        // Validasi setiap input
        when {
            state.firstName.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Nama depan tidak boleh kosong!") }
                return
            }
            state.lastName.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Nama belakang tidak boleh kosong!") }
                return
            }
            state.foodName.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Nama makanan tidak boleh kosong!") }
                return
            }
            state.calories.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Kalori tidak boleh kosong!") }
                return
            }
            state.calories.toIntOrNull() == null || state.calories.toInt() <= 0 -> {
                _uiState.update { it.copy(errorMessage = "Kalori harus angka lebih dari 0!") }
                return
            }
        }

        // Kalau semua valid → gabungkan nama depan & belakang
        val fullName = "${state.firstName.trim()} ${state.lastName.trim()}"
        val resultText = """
            Data berhasil disimpan!
            Nama: $fullName
            Makanan: ${state.foodName}
            Kalori: ${state.calories} kcal
        """.trimIndent()

        // Update state untuk menampilkan hasil
        _uiState.update {
            it.copy(
                resultText = resultText,
                errorMessage = ""
            )
        }
    }
}
