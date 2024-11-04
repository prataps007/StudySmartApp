package com.example.studysmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.studysmart.domain.model.Subject
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Task
import com.example.studysmart.ui.theme.StudySmartTheme
import com.ramcosta.composedestinations.DestinationsNavHost



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Enables edge-to-edge display

        setContent {
            StudySmartTheme {
                //DestinationsNavHost(navGraph = NavGraphs.root)
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

val subjects = listOf(
    Subject("Maths", 10f, colors = Subject.subjectCardColors[0], subjectId = 0),
    Subject("English", 10f, colors = Subject.subjectCardColors[1], subjectId = 1),
    Subject("Hindi", 10f, colors = Subject.subjectCardColors[2], subjectId = 2),
    Subject("Science", 10f, colors = Subject.subjectCardColors[3], subjectId = 3),
    Subject("SST", 10f, colors = Subject.subjectCardColors[0], subjectId = 4),
)

val tasks = listOf(
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 0, relatedToSubject = "Maths", isComplete = true, taskId = 0, taskSubjectId = 0),
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 1, relatedToSubject = "Maths", isComplete = false, taskId = 1, taskSubjectId = 0),
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 2, relatedToSubject = "Maths", isComplete = false, taskId = 2, taskSubjectId = 0),
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 1, relatedToSubject = "Maths", isComplete = false, taskId = 3, taskSubjectId = 0),
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 0, relatedToSubject = "Maths", isComplete = false, taskId = 4, taskSubjectId = 0),
    Task(title = "Prepare notes", description = "", dueDate = 0L, priority = 2, relatedToSubject = "Maths", isComplete = true, taskId = 5, taskSubjectId = 0)
)

val sessions = listOf(
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
    Session(sessionSubjectId = 0, relatedToSubject = "Maths", date = 0L, duration = 2, sessionId = 0,),
)
