// FoodSnapViewModel.kt
package com.example.foodsnapform.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class FoodFormState(
    val firstName: String = "",
    val lastName: String = "",
    val foodName: String = "",
    val calories: String = "",
    val errorMessage: String = "",
    val resultText: String = ""
)

class FoodSnapViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FoodFormState())
    val uiState: StateFlow<FoodFormState> = _uiState

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

    fun submitData() {
        val state = _uiState.value
        if (state.firstName.isBlank() || state.lastName.isBlank() ||
            state.foodName.isBlank() || state.calories.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Semua field wajib diisi!") }
            return
        }

        val calorieValue = state.calories.toIntOrNull()
        if (calorieValue == null || calorieValue <= 0) {
            _uiState.update { it.copy(errorMessage = "Kalori harus angka > 0!") }
            return
        }

        val fullName = "${state.firstName} ${state.lastName}"
        val result = "Data berhasil disimpan:\n" +
                "Nama: $fullName\nMakanan: ${state.foodName} (${state.calories} kcal)"

        _uiState.update {
            it.copy(errorMessage = "", resultText = result)
        }
    }
}
