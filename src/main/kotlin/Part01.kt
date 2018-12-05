fun main(args: Array<String>) {
    var i = 0
    var j = 0
    while (i <= 10) {
        println(i)
        i++
    }

    do {
        println(j)
        j++
    } while (j <= 10)

}

private fun m13() {
    //foreach循环
    var str = "abcd"
    str.forEach {
        println(it)
    }
    str.forEachIndexed { index, c -> println("$index----$c") }
}

private fun m12() {
    var str = "abcd"
    //for循环
    for (c in str) {
        println(c)
    }
    println("================")
    for (withIndex in str.withIndex()) {
        println(withIndex.index)
        println(withIndex.value)
        println(withIndex)
    }
    println("========对上面解构========")
    for ((index, c) in str.withIndex()) {
        println(index)
        println(c)
    }
}

private fun m10() {
    val a = 10
    val b = 20
    var max = max(a, b)
    println(max)
}

//kotlin的if语句有返回值的  java if语句是没有返回值的
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
//也可以简化成如下代码
//fun max(a: Int, b: Int) = if (a > b) a else b

private fun m09() {
    //嵌套函数
    fun sayHello() {
        println("hello")
    }
    sayHello()
}

//无参无返回值
fun sayHello() {//返回值
    println("hello")
}

//有参无返回值
fun sayHello(name: String) {
    println("hello $name")
}

//有参有返回值
fun getLength(name: String): Int {
    return name.length
}

//无参有返回值
fun get(): String {
    return "hello"
}

private fun m08() {
    //m+n
    var m: Int
    var n: Int
    //从控制台输入m和n
    m = readLine()?.toInt() ?: -1
    n = readLine()?.toInt() ?: -1

    println("m+n=" + (m + n))
}

private fun m07() {
    /**
     * val str:String 非空类型 不能赋值为null
     * val str: String? 可空类型 可以赋值为null

     *  空安全调用符:?.
     * 空值处理的运算符
     * 可空类型  Int?
     * 关闭空检查  a!!
     * 空安全调用符 a?.toInt
     * Elvis操作符  ?:
     */
    var str: String? = null
    //空安全调用符 返回的值其实就是可空类型
//    str?.toInt()
    //告诉编译器  不要检查了  我一定不为空  还是可能为空  不建议使用
//    str!!.toInt()
    var b = str?.toInt() ?: -1
    println(b)
//    if (str == null) {
//        return -1
//    } else {
//        return str.toInt()
//    }
}

private fun m06() {
    //定义二元元组 姓名  年纪
    val pair1 = Pair<String, Int>("frank", 20)
    val pair2 = "frank" to 20
    println(pair1.first)
    println(pair2.second)
    println(pair2.first)
    println(pair2.second)

    //三元元组
    val triple = Triple<String, Int, String>("frank", 20, "666")
    println(triple.first)
    println(triple.second)
    println(triple.third)
}

private fun m05() {
    //定义普通字符串
    var addr1 = "上海市闵行区申长路"
    var addr2 = "上海市\n闵行区\n申长路"
    //定义原样输出字符串
    var addr3 = """
        上海市
        闵行区
        申长路
    """.trimIndent()
    println(addr1)
    println(addr2)
    println(addr3)
    var name = "   frank  "
    println(name)
    println(name.trim())

    //指定规则trim
    var str = """
        ,apple
        ,banana
        ,orange
    """.trimMargin(",")
    println("str===$str===")

    //字符串比较
    val s1 = "frank"
    val s2 = String(charArrayOf('f', 'r', 'a', 'n', 'k'))
    //equals  比较值  true
    println(s1.equals(s2))
    //== 比较的也是值
    println(s1 == s2)
    //=== 比较地址值 false
    println(s1 === s2)

    //字符串切割
    var a = "张三,李四,王五"
    println(a.split(","))
    //多条件切割
    val b = "frank.lucy-shannon"
    println(b.split(".", "-"))

    val path = "C:/Users/w1138/Desktop/w/b.txt"
    //获取前6个字符
    println(path.substring(0, 6))
    println(path.substring(0..5))//0到5
    //把第一个r之前的字符截取
    println(path.substringBefore("w"))
    //把最后一个r之前的字符截取
    println(path.substringBeforeLast("w"))
    //把第一个r之后的字符截取
    println(path.substringAfter("w"))
    //把最后一个r之后的字符截取
    println(path.substringAfterLast("w"))

    var name1 = "frank"
    println("my name is $name1")
}

private fun m04() {
    //项目开发中尽量使用val  实在不能使用val再使用var
    //可变变量
    var a = 10
    a = 20
    val d = 20
    //const val e = 20  报错,const不能修饰局部变量
    //不可变变量
    // d = 50
    // b = 30
}

private fun m03() {
    //kotlin智能类型推断
    var a: Int = 10
    //类型安全的语言:类型一但确定,不再改变了
    //kotlin编译器推断出Int类型
    var b = 10
//    b = false
    var e = 10L//long

    var c = "张三"
    var d = 'a'

    //String和int类型转换
    //to转换基本数据类型
    var m = 10
    var s = "10"
    println(s.toInt())
    s.toByte()
    //int类型和long类型转换
    //不同的数据类型不能相互赋值
    //kotlin数据类型可以通过to方法进行相互转换
    var u = 10
    var v = 10L
    v = u.toLong()//Int赋值给Long类型
    u = v.toInt()//Long赋值给Int类型

    //kotlin                    java                    js
    //最严格的类型检查        只能小的赋值给大的     最宽松
}

private fun m02() {
    var b: Boolean = false
    var byte: Byte = 10
    var int: Int = 20
    var long: Long = 40
    var char: Char = 'a'
    var double: Double = 1.1234567
    var float: Float = 1.1234567f
    var short: Short = 10
}

private fun m01() {
    println("hello kotlin")
}