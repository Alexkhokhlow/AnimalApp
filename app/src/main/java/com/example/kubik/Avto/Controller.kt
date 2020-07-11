package com.example.kubik.Avto


data class Person(val name:String,
                    val age:Int)

class Controller: Task {




    override fun getAvto(): String {

        val a:MutableList<String> = mutableListOf("1","2")
        val b : MutableMap <String?,Int> = mutableMapOf("3" to 2, "2" to 3)



           val hashMap:HashMap<Int,Person> = HashMap()
        val person = Person("Alex",2)
        val person1 = Person("Alex",2)
        val person2 = Person("Alex",21)
        hashMap[1] = person
        hashMap[3] = person1
        hashMap[2] = person2

            return hashMap.toString();
    }


}