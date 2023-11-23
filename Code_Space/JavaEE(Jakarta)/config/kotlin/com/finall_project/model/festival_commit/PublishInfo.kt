package com.finall_project.model.festival_commit

import java.util.Date

class PublishInfo (
    val publisher:String,
    val publishStartTime:Date,
    val publishEndTime:Date,
    val publishScript:String,
    val publishFestival:Festival
)