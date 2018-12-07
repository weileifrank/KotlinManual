fun main(args: Array<String>) {
    set {
        name
        33
    }
    set2 {
        true
        3
    }
}
fun set(block: Data.() -> Unit) {
    block(Data())
    Data().block()
}
fun set2(block: () -> Int) {
    block()
}
class Data {
    var name = "张三"
}
