package ox.fernandonogueira.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OxExampleApplication

fun main(args: Array<String>) {
  runApplication<OxExampleApplication>(*args)
}
