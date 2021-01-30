/**
 * https://exercism.io/my/tracks/kotlin
 * Custom Set
 */

class CustomSet(vararg n: Int) {

    private val list: MutableList<Int> = n.toMutableList()

    fun isEmpty(): Boolean = list.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.list.containsAll(list)

    fun isDisjoint(other: CustomSet): Boolean = !other.list.any { list.contains(it) }

    fun contains(other: Int): Boolean = list.contains(other)

    fun intersection(other: CustomSet): CustomSet = also { list.retainAll(other.list) }

    fun add(other: Int) = let { !list.contains(other) && list.add(other) }

    override fun equals(other: Any?): Boolean =
            other is CustomSet && list.size == other.list.size && list.containsAll(other.list)

    override fun hashCode(): Int = list.sorted().hashCode()

    override fun toString(): String = list.toString()

    operator fun plus(other: CustomSet): CustomSet = also { other.list.forEach { add(it) } }

    operator fun minus(other: CustomSet): CustomSet  = also { other.list.forEach { list.remove(it)} }
}
