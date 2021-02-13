package com.example.postgresjackson.domain

typealias Id = Int
typealias Username = String

data class Questionnaire(
    val id: Id,
    val name: String,
    val sections: List<Section>
)

data class Section(
    val id: Id,
    val title: String,
    val questions: List<Question>
)

data class Question(
    val id: Id,
    val label: String,
    val category: Category,
    val answer: Answer
)

enum class Category {
    BREAD, CODE, DRAG;
}

sealed class Answer {
    object NotAnswered : Answer()
    data class Answered(val answer: String) : Answer()
    data class Approved(val answer: String, val reviewer: Username) : Answer()
}