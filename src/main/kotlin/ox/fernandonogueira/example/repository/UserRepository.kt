package ox.fernandonogueira.example.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ox.fernandonogueira.example.entity.User

interface UserRepository : MongoRepository<User, String> {
}
