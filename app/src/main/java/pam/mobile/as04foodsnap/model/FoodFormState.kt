package pam.mobile.as04foodsnap.model

/**
 * Data class ini berfungsi untuk menampung seluruh state input form.
 * ViewModel akan meng-update nilainya dan UI akan menampilkannya.
 */
data class FoodFormState(
    val firstName: String = "",
    val lastName: String = "",
    val foodName: String = "",
    val calories: String = "",
    val errorMessage: String = "",
    val resultText: String = ""
)
