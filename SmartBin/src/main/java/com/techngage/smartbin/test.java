package com.techngage.smartbin;

/**
 * Created by aviraj_madkaiker on 6/7/2016.
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.lang.Integer;
import java.net.UnknownHostException;
import java.util.List;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import static java.lang.Integer.*;

public class test {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("students");

        DBCollection collection = database.getCollection("grades");

        BasicDBObject query = new BasicDBObject("type", "homework");
        DBCursor cursor = collection.find(query).sort(new BasicDBObject("student_id", 1).append("score", -1));
        List<Object> map = new ArrayList<Object>();
        Integer test = 0;
        ObjectId prev = new ObjectId();
        try {
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
                Integer student_id = (Integer) obj.get("student_id");
                System.out.println(obj);
                System.out.println("test " + test + " <--> " + student_id);
                if (!test.equals(student_id)) {
                    System.out.println("\t### removing "+student_id+", _id "+prev.toString());
                    map.add(prev);
                }
                test = student_id;
                prev = (ObjectId) obj.get("_id");
            }
            map.add(prev);
        } finally {
            cursor.close();
        }
        for (int i=0; i < map.size(); i++) {
            System.out.println("going to remove: "+map.get(i));
            collection.remove(new BasicDBObject("_id",map.get(i)));
        }
    }
}
