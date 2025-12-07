package com.example.ai37b.model

data class UserModel(
    val userId : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val email : String = "",
    val gender : String = "",
    val dob : String = "",
){
    fun toMap() : Map<String,Any?>{
        return mapOf(
            "userId" to userId,
            "firstName" to firstName,
            "lastName" to lastName,
            "email" to email,
            "gender" to gender,
            "dob" to dob,
        )
    }
}

