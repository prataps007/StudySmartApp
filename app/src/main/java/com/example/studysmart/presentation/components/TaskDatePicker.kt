package com.example.studysmart.presentation.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDatePicker(
    state: DatePickerState,
    isOpen: Boolean,
    confirmButtonText: String = "OK",
    dismissButtonText: String = "Cancel",
    onDismissRequest: () -> Unit,
    onConfirmButtonClicked: () -> Unit
) {

    if (isOpen) {
        DatePickerDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Instant
                            .ofEpochMilli(state.selectedDateMillis ?: 0L)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
                        val currentDate = LocalDate.now(ZoneId.systemDefault())

                        // Check if the selected date is today or in the future
                        if (selectedDate >= currentDate) {
                            onConfirmButtonClicked() // Only confirm if date is valid
                        } else {
                            // Show warning or handle invalid date case
                        }
                    }
                ) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = dismissButtonText)
                }
            },
            content = {
                DatePicker(state = state)
            }
        )
    }
}
