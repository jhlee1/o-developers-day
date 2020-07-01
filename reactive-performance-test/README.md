# This is a collection of examples in the book
[Hands-On Microservices with Kotlin: Build reactive and cloud-native microservices with Kotlin using Spring 5 and Spring Boot 2.0](https://www.amazon.com/Hands-Microservices-Kotlin-cloud-native-microservices-ebook/dp/B077THJ1G4)

I have changed some parts for readability

## How to install MongoDB
- I have installed enterprise version because it's free for trial and development 
- [Download and install through here](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/)


### Run mongo server
 ```
$ mkdir data
$ mongod -dbpath data
```
### Connect to the mongo server
```
$ mongo
> db.version()
> exit
bye
```
### Create a DB

```
> show dbs
admin   0.000GB
config  0.000GB
local   0.000GB
```

- admin: Holds different security and administration information
- local: Stores the data required for this instance of our MongoDB server

```
> use kotlin-msa
switched to db kotlin-msa
> db.createCollection("Customers")
{ "ok" : 1 }
> show dbs
```

- You are supposed to create collection before you exit the client connection because the database won't be created until you make a collection
- The books says the collection won't be created until I insert a document, but it is created without document.
- collection names are case-sensitive. `db.Customer` is totally different from `db.customer`
  

```
> show collections
Customers
```
### Basic commands

- Insert
```
> db.Customers.insertOne( { "name" : "spring" } )
{
        "acknowledged" : true,
        "insertedId" : ObjectId("5e9e4cc2d35a132b799a3f1d")
}

> db.Customers.insertMany( [ { "name" : "reactive" }, { "name" : "microservices" } ] )
{
        "acknowledged" : true,
        "insertedIds" : [
                ObjectId("5e9e4c284b3af2f98054843c"),
                ObjectId("5e9e4c284b3af2f98054843d")
        ]
}
```

- Read

```
> db.Customers.find()
{ "_id" : ObjectId("5e9e4c284b3af2f98054843c"), "name" : "reactive" }
{ "_id" : ObjectId("5e9e4c284b3af2f98054843d"), "name" : "microservices" }
{ "_id" : ObjectId("5e9e4cc2d35a132b799a3f1d"), "name" : "spring" }

> db.Customers.find({"name": "spring"})
{ "_id" : ObjectId("5e9e4cc2d35a132b799a3f1d"), "name" : "spring" }
```

- Update
```
> db.Customers.update({"_id": ObjectId("5e9e4cc2d35a132b799a3f1d") }, { "name" : "super spring" })
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
```

- Remove
```
> db.Customers.remove({ "_id" : ObjectId("5e9e4cc2d35a132b799a3f1d")})
WriteResult({ "nRemoved" : 1 })
```

### Run DB for this project
```
$ mongod -dbpath data --port 27700
```