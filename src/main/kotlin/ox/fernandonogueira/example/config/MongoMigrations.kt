package ox.fernandonogueira.example.config

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import ox.engine.Ox

@Component
class MongoMigrations() {

  private val logger = LoggerFactory.getLogger(MongoMigrations::class.java)

  @Value("\${spring.data.mongodb.host}")
  lateinit var mongoHost: String

  @EventListener
  fun onApplicationEvent(event: ContextRefreshedEvent) {
    val mongo = MongoClient(ServerAddress(mongoHost))
    try {
      Ox.configure(
        mongo,
        "ox.fernandonogueira.example.db.migrations",
        "ox-example"
      ).up()
    } catch (e: Exception) {
      logger.error("Error running migrations", e)
    } finally {
      mongo.close()
    }
  }
}


