package com.example.postgresjackson.database

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet

@Component
class Database(private val jdbc: NamedParameterJdbcTemplate) {

    fun <T> findMany(
        mapper: (ResultSet) -> T,
        rawQuery: String,
        params: Map<String, Any> = emptyMap()
    ): T = jdbc
        .query(rawQuery, params) { resultSet, _ -> mapper(resultSet) }
        .first()

    fun <T> findOne(
        mapper: (ResultSet) -> T,
        rawQuery: String,
        params: Map<String, Any> = emptyMap()
    ): T? = jdbc
        .query(rawQuery, params) { resultSet, _ -> mapper(resultSet) }
        .firstOrNull()
}