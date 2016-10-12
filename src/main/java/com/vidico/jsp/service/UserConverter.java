/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidico.jsp.service;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.vidico.jsp.model.User;
import org.bson.types.ObjectId;

/**
 *
 * @author vishal
 */
public class UserConverter {

    public static DBObject toDBObject(User u) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("username", u.getUsername())
                .append("password", u.getPassword())
                .append("_id", u.getId());

        return builder.get();
    }

    public static User toUser(DBObject doc) {
        User u = new User();
        u.setUsername((String) doc.get("username"));
        u.setPassword((String) doc.get("password"));
        u.setId((ObjectId) doc.get("_id"));
        return u;
    }
}