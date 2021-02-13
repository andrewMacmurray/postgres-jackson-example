package com.example.postgresjackson.database

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.sql.ResultSet

object JsonQuery {
    const val JSON_OUTPUT = "json_output"

    val objectMapper: ObjectMapper =
        jacksonObjectMapper().registerModule(AnswerDeserializer.module)

    inline fun <reified T> parser(): (ResultSet) -> T = {
        objectMapper.readValue(it.getString(JSON_OUTPUT))
    }
}
