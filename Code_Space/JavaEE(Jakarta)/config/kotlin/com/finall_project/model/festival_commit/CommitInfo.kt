package com.finall_project.model.festival_commit

import com.finall_project.model.class_about.Student
import java.util.Date

class CommitInfo(
    val commitStartTime:Date,
    val commitEndTime:Date,
    val commitStudent: Student,
    val commitState:String,
    val commitTarget:String
)