package com.example.ai37b

fun main() {

    val age = arrayOf(10,20,30)
    age[3] = 50
    println(age[3])

    val age1 = ArrayList<Int>()
    val age2 = arrayListOf<Int>(10,20,30)

    age1.add(5)

    age2.add(10)

   //
    /*
    for(int i = 0;i<=10;i++){
        sout(i)
     */

    for(i in 0 until 10 step 2){
        print(i)
    }

//    for(i in 10 downTo ){
//
//    }








//    //mutable
//    var name : String = "sandis"
//    name = "ram"
//
//    //immutable
//    val age : Int = 15
//    //my name is sandis and age is 15
//    print("My name is " + name + "and age is " + age)
//    print("My name is ${name.uppercase()} and age is $age")
    val result = sum(10,10)
    println(result)

}


fun sum(a:Int,b:Int) : Int{
    return a+b;
}

fun login(username:String,password:String) :Unit{

}