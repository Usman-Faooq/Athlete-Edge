package com.buzzware.athleteedge.classes

data class DummyModels(
    val name : String = "",
    val check : Boolean = false
)

data class ProgressCoursesModel(
    val title : String = "",
    val note : String = "",
    val progress : Int = 0,
)

data class FeaturedCoursesModel(
    val title : String = "",
    val name : String = ""
)

data class CourseOverviewModel(
    val title : String = "",
    val note : String = ""
)

data class QuestionModel(
    val question : String = "",
    val option1 : String = "",
    val option2 : String = "",
    val option3 : String = "",
    val option4 : String = "",
)
