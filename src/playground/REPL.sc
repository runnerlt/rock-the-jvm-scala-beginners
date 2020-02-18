val fn: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x * y * z
println(fn(5, 8, 3))

val fn2: (Int) => (Int) => (Int) => (Int) = x => y => z => x * y * z
println(fn2(5)(8)(3))

def fn3(x: String)(y: String): String = s"${x} ahoy ${y}"
println(fn3("labas")("rytas"))
