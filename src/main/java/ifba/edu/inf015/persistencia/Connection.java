package ifba.edu.inf015.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Connection {

	public static void main(String[] args) throws Exception {
		final MongoClient mongoClient = createConnectionToMyMongoDB();

		if (mongoClient != null) {
			System.out.println("Conexão com banco de dados obtida com sucesso!");
			((MongoClient) mongoClient).close();
		}

		mongoClient.close();

	}
	
	public static MongoClient createConnectionToMyMongoDB() throws Exception {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:2717"));
		return (MongoClient) mongoClient;

	}

}
