
public class Principal {

	public static void main(String[] args) {
		
		NóÁrvore abb = new NóÁrvore();
		
		abb.insere(abb, 6);
		abb.insere(abb, 8);
		abb.insere(abb, 4);
		abb.insere(abb, 5);
		abb.insere(abb, 2);
		abb.insere(abb, 3);
		abb.insere(abb, 1);
		abb.insere(abb, 9);
		abb.insere(abb, 7);
		
		NóÁrvore resultado = abb.busca(abb, 10);
		
		if (resultado == null) {
			System.out.println("Não ecnontrei o nó!");
		} else {
			System.out.println("Encontrei o nó" + resultado.valor);
		}
		
		abb.imprime(abb);
		abb.remover(abb, 5);
		abb.imprime(abb);
		

	}

}
