fun main() {
    val n : Long = 118372
    var list = ArrayList<Long>()
    for (i in n.toString().chars()){
        list.add(i - 48L)
    }
    list.sort()
    var result = 0L
    for(i in list.size-1 downTo 0){
        result = result * 10 + list.get(i)
    }
    println(result)
}