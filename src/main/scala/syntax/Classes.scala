package syntax

// Class
// Case class
// Object
// Companion Object
// Trait

trait Say {

  def sayMyCompleteName(lastName: String) : Unit

}

case class Person(uuid: String, name: String) extends Say {

  override def sayMyCompleteName(lastName: String): Unit = println(s" $name $lastName")


}

object Person {

  def apply(uuid: String, name: String): Person = new Person(uuid, name)

  private val name: String = "Person"

  def saySomething(): Unit = println("Something")


}

object Main2 extends App {

  val person = Person("1", "Martin")
  val person2 = Person("1", name = "Martin")

  val person3 = person.copy(uuid = "Ordersky")

  println(person)
  println(person2)
  println(person == person2)

  println(person3)
  Person.saySomething()

  person.sayMyCompleteName("Ordersky")

}