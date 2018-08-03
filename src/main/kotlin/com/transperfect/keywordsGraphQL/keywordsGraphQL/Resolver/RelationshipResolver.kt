package com.transperfect.keywordsGraphQL.keywordsGraphQL.Resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.transperfect.keywordsGraphQL.keywordsGraphQL.Databases.PersonDao
import com.transperfect.keywordsGraphQL.keywordsGraphQL.model.Relationship
import org.springframework.stereotype.Component

@Component
class RelationshipResolver(private val personDao: PersonDao) : GraphQLResolver<Relationship> {
    fun getFrom(relationship: Relationship) = personDao.getPersonById(relationship.from)
    fun getTo(relationship: Relationship) = personDao.getPersonById(relationship.to)
}