package main.java.com.jpa.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbCall {
	private MongoClient mongoClient;
	private String dbName = "video";
	private String collectionName = "movies";
	private MongoCollection<Document> movieCollection;
	private String mongoURIString = "mongodb://localhost";
	
	public MongoDbCall(){
		mongoClient = new MongoClient(new MongoClientURI(mongoURIString));
		MongoDatabase movieDatabase = mongoClient.getDatabase(dbName);
	    movieCollection = movieDatabase.getCollection(collectionName);
	}
	
	//Get movie details by imdb
	//testing
	public String getMovieByImdb(final String title) {
		final List<Document> movie = new ArrayList<Document>();
		FindIterable<Document> iterable = movieCollection.find(new Document("title", title));
		iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
            	movie.add(document);
            }
        });

	    return movie.get(0).toJson();
	  }
	
//Java 8 code (Optional for handling null pointer exceptions)	
/*	public Optional<Book> readByImdb(@Nonnull final String isbn) {
	    checkNotNull(isbn, "Argument[isbn] must not be null");

	    DBObject query = new BasicDBObject("isbn", isbn);
	    DBObject dbObject = booksCollection.findOne(query);

	    if (dbObject != null) {
	      Book book = (Book) AppUtils.fromDBObject(dbObject, Book.class);
	      logger.info("Retrieved book for isbn[{}]:{}", isbn, book);
	      return Optional.of(book);
	    }
	    logger.info("Book with isbn[{}] does not exist", isbn);
	    return Optional.empty();
	  }*/
	
}

