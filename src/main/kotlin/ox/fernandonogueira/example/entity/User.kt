package ox.fernandonogueira.example.entity

import org.springframework.data.annotation.Id


data class User(
  @Id
  val id: String,

  val name: String,

  val email: String,
)
