/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidico.jsp.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.vidico.jsp.model.User;
import com.vidico.jsp.service.UserConverter;
import org.bson.types.ObjectId;

/**
 *
 * @author vishal
 */
public class UserDAO {

    private DBCollection col;

    public UserDAO(MongoClient mongo) {
        this.col = mongo.getDB("vidico").getCollection("users");
    }

    public User creatUser(User u) {
        DBObject doc = UserConverter.toDBObject(u);
        this.col.insert(doc);
        u.setId((ObjectId) doc.get("_id"));
        return u;
    }
}