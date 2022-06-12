
public class NóÁrvore {
	int valor;
	NóÁrvore direita;
	NóÁrvore esquerda;
	
	public void imprime(NóÁrvore a) {
		if (a != null) {
			// Em ordem (esquerda, raiz, direita).
			imprime(a.esquerda);
			System.out.println(a.valor);
			imprime(a.direita);
		}
	}
	
	public NóÁrvore busca(NóÁrvore raiz, int valorprocurado) {
		if (raiz == null)
			return null;
		else if (raiz.valor > valorprocurado)
			return busca (raiz.esquerda, valorprocurado);
		else if (raiz.valor < valorprocurado)
			return busca (raiz.direita, valorprocurado);
		else
			return raiz;
	}
	
	public NóÁrvore insere(NóÁrvore a, int v) {
		//caso a árvore não tenha filhos (ou seja, nula)
		if (a == null) {
			a = new NóÁrvore();
			a.valor = v;
			a.esquerda = a.direita = null;
		}
		//inserir na árvore esquerda
		else if(v < a.valor)
			a.esquerda = insere(a.esquerda, v);
		//inserir na árvore direita
		else
			a.direita = insere(a.direita, v);
		
		//caso a árvore seja nula, o retorno do método é o nó que foi inserido
		return a;		
	}
	
	public NóÁrvore remover(NóÁrvore r, int v) {
		if(r == null)
			return null;
		else if (r.valor > v)
			r.esquerda = remover(r.esquerda, v);
		else if (r.valor < v)
			r.direita = remover (r.direita, v);
		else {
			//achou o nó a ser removido;
			//temos 4 situações:
			if(r.esquerda == null && r.direita == null) {
				r = null;
			// 2- Se o nó tem filhos apenas à direita:
			} else if (r.esquerda == null) {
				NóÁrvore temp = r;
				r = r.direita;
			//3 - Se o nó tem filho apenas à esquerda:	
			} else if (r.direita == null) {
				NóÁrvore temp = r;
				r = r.esquerda;
			//4 - Se o nó tem os dois filhos:
			} else {
				NóÁrvore subesquerda = r.esquerda;
				while (subesquerda.direita != null) {
				//Capturar o maior nó da subárvore esquerda:
					subesquerda = subesquerda.direita;
				}
				//subesquerda.valor é o maior nó da subárvore esquerda:
				r.valor = subesquerda.valor; //troca as informações.
				subesquerda.valor = v;
				r.esquerda = remover(r.esquerda, v);
			}
		}
		
		return r;
	}
}












