package com.example.postgresjackson.database

import com.example.postgresjackson.domain.Id
import com.example.postgresjackson.domain.Questionnaire
import org.springframework.stereotype.Repository

@Repository
class QuestionnairesRepository(private val database: Database) {

    fun findAll(): List<Questionnaire> =
        database.findMany(
            JsonQuery.parser(),
            Queries.findAll
        )

    fun findById(id: Id): Questionnaire? =
        database.findOne(
            JsonQuery.parser(),
            Queries.findById,
            mapOf("id" to id)
        )
}
