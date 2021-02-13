package com.example.postgresjackson.web

import com.example.postgresjackson.database.QuestionnairesRepository
import com.example.postgresjackson.domain.Id
import com.example.postgresjackson.domain.Questionnaire
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionnairesController(private val repository: QuestionnairesRepository) {

    @GetMapping("/questionnaires")
    fun findAll(): List<Questionnaire> =
        repository.findAll()

    @GetMapping("/questionnaires/{id}")
    fun findById(@PathVariable id: Id): Questionnaire? =
        repository.findById(id)
}