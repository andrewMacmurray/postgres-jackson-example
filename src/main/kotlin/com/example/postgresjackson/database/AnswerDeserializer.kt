package com.example.postgresjackson.database

import com.example.postgresjackson.domain.Answer
import com.example.postgresjackson.domain.Answer.Answered
import com.example.postgresjackson.domain.Answer.Approved
import com.example.postgresjackson.domain.Answer.NotAnswered
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule

class AnswerDeserializer : JsonDeserializer<Answer>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Answer =
        p.readValueAs(Intermediate::class.java).toAnswer()

    class Intermediate(
        private val answer: String?,
        private val reviewedBy: String?
    ) {
        fun toAnswer(): Answer = when {
            answer != null && reviewedBy != null -> Approved(answer, reviewedBy)
            answer != null && reviewedBy == null -> Answered(answer)
            else -> NotAnswered
        }
    }

    companion object {
        val module: SimpleModule =
            SimpleModule().addDeserializer(Answer::class.java, AnswerDeserializer())
    }
}