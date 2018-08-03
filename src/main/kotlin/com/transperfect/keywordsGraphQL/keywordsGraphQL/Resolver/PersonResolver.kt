package com.transperfect.keywordsGraphQL.keywordsGraphQL.Resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLResolver
import com.transperfect.keywordsGraphQL.keywordsGraphQL.Databases.PersonDao
import com.transperfect.keywordsGraphQL.keywordsGraphQL.Databases.RelationshipDao
import com.transperfect.keywordsGraphQL.keywordsGraphQL.model.Person
import org.springframework.stereotype.Component

@Component
class PersonResolver(private val relationshipDao: RelationshipDao) : GraphQLResolver<Person> {
    fun relationships(person: Person, type: String?) =
            when (type) {
                null -> relationshipDao.getRelationshipsFromPerson(person.id)
                else -> relationshipDao.getRelationshipsOfTypeFromPerson(person.id, type)
            }
}

@Component
class PersonMutationResolver(private val personDao: PersonDao) : GraphQLMutationResolver {
    fun createPerson(name: String) = personDao.createPerson(name)
}