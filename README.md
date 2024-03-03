# Ox Example

This is a simple example of how to use the Ox library to manage MongoDB schema migrations.

## Usage

Run the docker compose file to start the MongoDB instance

```bash
docker compose up
```

Run the Spring Boot application

```bash
./gradlew bootRun
```

After running the application, you can check the MongoDB `users` collection in the `ox-example` database to see the
created index. Also, you can check the `migration_versions` collection to see the applied migration.



```
test> show databases
admin       40.00 KiB
config      12.00 KiB
local       40.00 KiB
ox-example  52.00 KiB
```

```
test> show dbs
admin       40.00 KiB
config      12.00 KiB
local       40.00 KiB
ox-example  52.00 KiB
test> use ox-example
switched to db ox-example
ox-example> show collections
migration_versions
users
ox-example> db.migration_versions.find()
[
  {
    _id: ObjectId('65e4f67fb158a54debe4a207'),
    version: 1,
    date: ISODate('2024-03-03T22:15:27.671Z')
  }
]
ox-example> db.users.getIndexes()
[
  { v: 2, key: { _id: 1 }, name: '_id_' },
  {
    v: 2,
    key: { email: 1 },
    name: 'idx_users_email',
    background: true,
    unique: true
  }
]
ox-example>
```


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

