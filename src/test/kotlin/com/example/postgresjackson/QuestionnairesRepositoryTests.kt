package com.example.postgresjackson

import com.example.postgresjackson.database.QuestionnairesRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class QuestionnairesRepositoryTests(@Autowired private val repository: QuestionnairesRepository) {

    @Test
    fun `finds questionnaires`() {
        val questionnaires = repository.findAll()

        assertEquals(2, questionnaires.size)
    }

    @Test
    fun `finds questionnaire by id`() {
        val id = 1
        val questionnaire = repository.findById(id)

        assertEquals(id, questionnaire?.id)
    }
}
