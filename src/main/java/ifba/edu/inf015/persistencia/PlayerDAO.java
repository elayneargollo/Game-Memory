package ifba.edu.inf015.persistencia;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ifba.edu.inf015.jogo.Player;
import ifba.edu.inf015.menu.Score;

public class PlayerDAO {

	private static MongoCollection<Document> jogadores;
	private static Document doc;
	
	public PlayerDAO() throws Exception {
		
		this.doc = new Document();

		MongoClient con = Connection.createConnectionToMyMongoDB();
		MongoDatabase bancoDeDados = con.getDatabase("jogoMemoria");
		jogadores = bancoDeDados.getCollection("jogador");
	}
	

	public void inserir(Player jogador) throws Exception {
		doc.put("nomeJogador", jogador.getNomeJogador());
		doc.put("pontuacao", jogador.getPontuacao());
		jogadores.insertOne(doc);
	}

	public static boolean procurarJogador(String nome) {

		FindIterable<Document> iterable = jogadores.find(doc.append("nomeJogador", nome));
		MongoCursor<Document> cursor = iterable.iterator();

		while (cursor.hasNext()) {
			return true;
		}

		return false;
	}

	public boolean isMaior(String nome, String pontuacao) {

		FindIterable<Document> iterable = jogadores.find(doc.append("nomeJogador", nome));
		MongoCursor<Document> cursor = iterable.iterator();

		int pontosAtual = Integer.parseInt(pontuacao);

		while (cursor.hasNext()) {

			String pontos = (String) ((cursor.next().get("pontuacao")));
			int pontosNoBanco = Integer.parseInt(pontos);

			if (pontosNoBanco < pontosAtual) {
				return true;
			}

		}

		return false;
	}

	public void update(String nome, String pontuacao) throws Exception {

		if (isMaior(nome, pontuacao)) {

			Document found = (Document) jogadores.find(new Document("nomeJogador", nome)).first();

			if (found != null) {

				Bson updatevalue = new Document("pontuacao", pontuacao);

				Bson updateoperation = new Document("$set", updatevalue);
				jogadores.updateOne(found, updateoperation);

			}
		}

	}

	public void mostrarScore() {
		Map<String, String> mapCache = buscaOrdenada();

		Score pontuacaoGeral = new Score();

		pontuacaoGeral.initComponents(mapCache);
		pontuacaoGeral.setVisible(true);
	}

	private static Map<String, String> buscaOrdenada() {
		Map<String, String> result = new LinkedHashMap<String, String>();

		FindIterable<Document> docs = jogadores.find().sort(new BasicDBObject("pontuacao", -1));

		for (Document doc : docs) {
			result.put(((doc.getString("nomeJogador"))), (doc.getString("pontuacao")));
		}
		
		return result;
	}

	public void deletar(String nome) {

		FindIterable<Document> iterable = jogadores.find(doc.append("nomeJogador", nome));
		MongoCursor<Document> cursor = iterable.iterator();

		while (cursor.hasNext()) {

			Bson delete = new Document("nomeJogador", cursor.next().get("nomeJogador"));
			jogadores.deleteOne(delete);

		}
	}
}

