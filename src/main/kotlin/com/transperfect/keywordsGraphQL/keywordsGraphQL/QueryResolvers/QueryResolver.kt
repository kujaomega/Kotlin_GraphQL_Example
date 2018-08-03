package com.transperfect.keywordsGraphQL.keywordsGraphQL.QueryResolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.transperfect.keywordsGraphQL.keywordsGraphQL.Databases.PersonDao
import com.transperfect.keywordsGraphQL.keywordsGraphQL.model.Person
import org.springframework.stereotype.Component

@Component
class Query : GraphQLQueryResolver {
    fun version() = "1.0.0"
}

@Component
class PersonQueryResolver(
        private val personDao : PersonDao
) : GraphQLQueryResolver {
    fun getPersonById(id: String) = personDao.getPersonById(id)
}