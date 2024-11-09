package com.example.studysmart.task

import com.example.studysmart.domain.model.Subject
import com.example.studysmart.util.Priority

sealed class TaskEvent {

    data class OnTitleChange(val title: String) : TaskEvent()

    data class OnDescriptionChange(val description: String) : TaskEvent()

    data class OnDueDateChange(val dueDate: Long?) : TaskEvent()

    data class OnPriorityChange(val priority: Priority) : TaskEvent()

    data class OnRelatedToSubjectChange(val subject: Subject) : TaskEvent()

    data object OnTaskIsCompleteChange : TaskEvent()

    object SaveTask : TaskEvent()

    object DeleteTask : TaskEvent()


}