package com.transperfect.keywordsGraphQL.keywordsGraphQL.Databases

import com.transperfect.keywordsGraphQL.keywordsGraphQL.model.Person
import org.springframework.stereotype.Component

@Component
class PersonDao {
    private val data = mutableListOf(
            Person(id = "qeii", name = "Queen Elizabeth II"),
            Person(id = "pp", name = "Prince Philip"),
            Person(id = "pc", name = "Prince Charles"),
            Person(id = "pw", name = "Prince William")
    )

    fun getPersonById(id: String) = data.firstOrNull { person -> person.id == id }
}