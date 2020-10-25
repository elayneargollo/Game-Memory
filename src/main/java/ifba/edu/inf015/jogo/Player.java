package ifba.edu.inf015.jogo;

public class Player {
	public String nomeJogador;
	private String pontuacao;

	public Player(String nomeJogador, String pontuacao) {
		this.nomeJogador = nomeJogador;
		this.pontuacao = pontuacao;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void isJogador(String nome, String Pontuacao) {
		if (this.getNomeJogador().equals(nome)) {
			this.setPontuacao(Pontuacao);
		}
	}

	@Override
	public String toString() {
		return "jogador [nomeJogador=" + nomeJogador + ", pontuacao=" + pontuacao + "]";
	}

}
