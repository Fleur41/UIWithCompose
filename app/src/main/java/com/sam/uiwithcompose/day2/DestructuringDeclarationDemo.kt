package com.sam.uiwithcompose.day2

data class User(
    val name: String,
    val age: Int
)

fun main() {
//    val user = User("Sammir", 24)
//    println(user.name)
//    println(user.age)

//    Destructuring-Declaration
    val (name, age) = User("Sammir", 24)
    println(name)
    println(age)

    val list = listOf(1, 2, 3)
    val (a, b, c) = list
    println(a)
    println(b)
    println(c)

}