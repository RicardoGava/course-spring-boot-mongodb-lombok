package com.ibm.mongodbcourse.repositories;

import com.ibm.mongodbcourse.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //{ <field>: { $regex: /pattern/, $options: '<options>' } }
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    //{ $and: [ { <expression1> }, { <expression2> } , ... , { <expressionN> } ] }
    //{ $or: [ { <expression1> }, { <expression2> }, ... , { <expressionN> } ] }
    //{ field: { $gte: value } } greater than or equal
    //{ field: { $lte: value } } less than or equal
    @Query("{ $and: [ { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] }, { date: { $gte: ?1 } } , { date: { $lt: ?2 } } ] } ")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
