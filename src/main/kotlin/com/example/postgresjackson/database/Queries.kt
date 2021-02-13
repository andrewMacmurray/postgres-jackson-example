package com.example.postgresjackson.database

import com.example.postgresjackson.database.JsonQuery.JSON_OUTPUT
import org.intellij.lang.annotations.Language

object Queries {

    @Language("SQL")
    private const val questions = """
        SELECT
            questions.section_id,
            json_agg(
                json_build_object(
                    'id', questions.id,
                    'label', questions.label,
                    'category', questions.category,
                    'answer', json_build_object(
                        'answer', questions.answer,
                        'reviewedBy', questions.reviewed_by
                    )
                )
            ) json
        FROM questions
        GROUP BY questions.section_id
    """

    @Language("SQL")
    private const val sections = """
        SELECT
            sections.questionnaire_id,
            json_agg(
                json_build_object(
                    'id', sections.id,
                    'title', sections.title,
                    'questions', questions.json
                )
            ) json
        FROM sections
        INNER JOIN ($questions) questions ON
        questions.section_id = sections.id
        GROUP BY sections.questionnaire_id
    """

    @Language("SQL")
    private const val questionnaires = """
        SELECT
            json_build_object(
                'id', questionnaires.id,
                'name', questionnaires.name,
                'sections', sections.json
            ) json
        FROM questionnaires
        INNER JOIN ($sections) sections ON
        sections.questionnaire_id = questionnaires.id
    """

    @Language("SQL")
    const val findAll = """
       WITH questionnaires as ($questionnaires) 
       SELECT json_agg(questionnaires.json) AS $JSON_OUTPUT
       FROM questionnaires
    """

    @Language("SQL")
    const val findById = """
        WITH questionnaires as ($questionnaires WHERE questionnaires.id = :id) 
        SELECT questionnaires.json AS $JSON_OUTPUT
        FROM questionnaires
    """
}