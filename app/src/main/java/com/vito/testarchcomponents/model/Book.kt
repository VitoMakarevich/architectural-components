package com.vito.testarchcomponents.model

class Book(val _id: String? = null, val name: String, val description: String) {

    constructor(name: String, description: String) : this(null, name, description)

}