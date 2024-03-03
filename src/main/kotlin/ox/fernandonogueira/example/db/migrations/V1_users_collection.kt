@file:Suppress("unused")

package ox.fernandonogueira.example.db.migrations

import ox.engine.internal.OxAction
import ox.engine.internal.OxEnvironment
import ox.engine.structure.Migration
import ox.engine.structure.OrderingType

class V1_users_collection : Migration {

  override fun up(env: OxEnvironment) {
    OxAction.createIndex("idx_users_email")
      .setCollection("users")
      .unique()
      .ifNotExists()
      .recreateIfNotEquals()
      .addAttribute("email", OrderingType.ASC)
      .dropDups()
      .execute(env)
  }

  override fun down(env: OxEnvironment) {
    OxAction.removeIndex("idx_users_email")
      .setCollection("users")
      .execute(env)
  }

}
