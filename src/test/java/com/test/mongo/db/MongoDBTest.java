package com.test.mongo.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import org.junit.Test;

public class MongoDBTest
{
    @Test
    public void writeTest() throws Exception
    {
        Mongo m = new Mongo("localhost", 27017);
        DB database = m.getDB("test");

        BasicDBObject testAddress = new BasicDBObject();
        testAddress.put("street", "10701 Test Drive");
        testAddress.put("phone", "818-818-8818");
        testAddress.put("city", "Kansas City");

        BasicDBObject testPerson = new BasicDBObject();
        testPerson.put("firstname", "Swaroop");
        testPerson.put("lastname", "database");
        testPerson.put("ssn", 1);
        testPerson.put("address", testAddress);

        DBCollection collection = database.getCollection("testCollection");
        collection.insert(testPerson);

        DBCursor cursor = collection.find();

        while (cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
    }

    public void testQuery() throws Exception
    {
        Mongo m = new Mongo("localhost", 27017);
        DB database = m.getDB("test");
        DBCollection collection = database.getCollection("testCollection");

        BasicDBObject query = new BasicDBObject();
        query.put("i", 71);

        DBCursor cur = collection.find(query);

        while (cur.hasNext())
        {
            System.out.println(cur.next());
        }
    }
}
