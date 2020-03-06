package exercises

object MapAndTuplesExercises extends App {

  val empty: Map[String, Set[String]] = Map()

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    // need to retrieve set of friends of each person
    val friendsA = network(personA) // calling () on map means call of apply / retrieve of value by key
    val friendsB = network(personB) // calling () on map means call of apply / retrieve of value by key

    // received network + tuple{i + Set{my old friend list + new friend} + tuple{i + Set{my old friend list + new friend}
    // by logic, duplicates should be here. But, SET eliminates duplicates automatically.
    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))

  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsOfA = network(personA)
    val friendsOfB = network(personB)

    network + (personA -> (friendsOfA - personB)) + (personB -> (friendsOfB - personA))
  }


  //  test add
  println(add(empty, "Juozas"))

  // network with 2  people
  println(add(add(empty, "Juozas"), "Dovile"))

  // and test friend
  println(friend(add(add(empty, "Juozas"), "Dovile"), "Juozas", "Dovile"))


}
