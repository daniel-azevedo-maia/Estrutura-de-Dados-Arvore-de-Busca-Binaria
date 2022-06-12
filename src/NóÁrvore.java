
public class N��rvore {
	int valor;
	N��rvore direita;
	N��rvore esquerda;
	
	public void imprime(N��rvore a) {
		if (a != null) {
			// Em ordem (esquerda, raiz, direita).
			imprime(a.esquerda);
			System.out.println(a.valor);
			imprime(a.direita);
		}
	}
	
	public N��rvore busca(N��rvore raiz, int valorprocurado) {
		if (raiz == null)
			return null;
		else if (raiz.valor > valorprocurado)
			return busca (raiz.esquerda, valorprocurado);
		else if (raiz.valor < valorprocurado)
			return busca (raiz.direita, valorprocurado);
		else
			return raiz;
	}
	
	public N��rvore insere(N��rvore a, int v) {
		//caso a �rvore n�o tenha filhos (ou seja, nula)
		if (a == null) {
			a = new N��rvore();
			a.valor = v;
			a.esquerda = a.direita = null;
		}
		//inserir na �rvore esquerda
		else if(v < a.valor)
			a.esquerda = insere(a.esquerda, v);
		//inserir na �rvore direita
		else
			a.direita = insere(a.direita, v);
		
		//caso a �rvore seja nula, o retorno do m�todo � o n� que foi inserido
		return a;		
	}
	
	public N��rvore remover(N��rvore r, int v) {
		if(r == null)
			return null;
		else if (r.valor > v)
			r.esquerda = remover(r.esquerda, v);
		else if (r.valor < v)
			r.direita = remover (r.direita, v);
		else {
			//achou o n� a ser removido;
			//temos 4 situa��es:
			if(r.esquerda == null && r.direita == null) {
				r = null;
			// 2- Se o n� tem filhos apenas � direita:
			} else if (r.esquerda == null) {
				N��rvore temp = r;
				r = r.direita;
			//3 - Se o n� tem filho apenas � esquerda:	
			} else if (r.direita == null) {
				N��rvore temp = r;
				r = r.esquerda;
			//4 - Se o n� tem os dois filhos:
			} else {
				N��rvore subesquerda = r.esquerda;
				while (subesquerda.direita != null) {
				//Capturar o maior n� da sub�rvore esquerda:
					subesquerda = subesquerda.direita;
				}
				//subesquerda.valor � o maior n� da sub�rvore esquerda:
				r.valor = subesquerda.valor; //troca as informa��es.
				subesquerda.valor = v;
				r.esquerda = remover(r.esquerda, v);
			}
		}
		
		return r;
	}
}












