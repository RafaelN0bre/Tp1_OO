import java.util.Scanner;

public class JogoDaForca {
	
	static Scanner ler = new Scanner(System.in);
	
	static String catalogo[][] = new String[51][51];
	
	public static void cadastroInicial(){
		catalogo[0][0] = "Animais";
		catalogo[0][1] = "Vaca";
		catalogo[0][2] = "Cachorro";
		catalogo[0][3] = "Urso";
		catalogo[0][4] = "Garça";
		catalogo[0][5] = "Pato";
		catalogo[0][6] = "Galinha";
		catalogo[0][7] = "Leão";
		catalogo[0][8] = "Leopardo";
		catalogo[0][9] = "Zebra";
		catalogo[0][10] = "Gorila";

		catalogo[1][0] = "Cores";
		catalogo[1][1] = "Azul";
		catalogo[1][2] = "Amarelo";
		catalogo[1][3] = "Verde";
		catalogo[1][4] = "Vermelho";
		catalogo[1][5] = "Marrom";
		catalogo[1][6] = "Roxo";
		catalogo[1][7] = "Preto";
		catalogo[1][8] = "Branco";
		catalogo[1][9] = "Rosa";
		catalogo[1][10] = "Laranja";
		
		catalogo[2][0] = "Frutas";
		catalogo[2][1] = "Maçã";
		catalogo[2][2] = "Banana";
		catalogo[2][3] = "Melão";
		catalogo[2][4] = "Morango";
		catalogo[2][5] = "Melancia";
		catalogo[2][6] = "Manga";
		catalogo[2][7] = "Caju";
		catalogo[2][8] = "Ameixa";
		catalogo[2][9] = "Coco";
		catalogo[2][10] = "Mamão";
		
		catalogo[3][0] = "Espécies de árvore";
		catalogo[3][1] = "Carvalho";
		catalogo[3][2] = "Bétula";
		catalogo[3][3] = "Eucalipto";
		catalogo[3][4] = "Pinheiro";
		catalogo[3][5] = "Acácia";
		catalogo[3][6] = "Jacarandá";
		catalogo[3][7] = "Mogno";
		catalogo[3][8] = "Castanheira";
		catalogo[3][9] = "Sequóia";
		catalogo[3][10] = "Jatobá";
		
		catalogo[4][0] = "Objetos";
		catalogo[4][1] = "Garfo";
		catalogo[4][2] = "Luminária";
		catalogo[4][3] = "Janela";
		catalogo[4][4] = "Garrafa";
		catalogo[4][5] = "Prato";
		catalogo[4][6] = "Jarro";
		catalogo[4][7] = "Televisão";
		catalogo[4][8] = "Rádio";
		catalogo[4][9] = "Cadeira";
		catalogo[4][10] = "Livro";
		
		catalogo[5][0] = "Órgãos";
		catalogo[5][1] = "Coração";
		catalogo[5][2] = "Pulmão";
		catalogo[5][3] = "Estômago";
		catalogo[5][4] = "Laringe";
		catalogo[5][5] = "Faringe";
		catalogo[5][6] = "Pâncreas";
		catalogo[5][7] = "Fígado";
		catalogo[5][8] = "Apêndice";
		catalogo[5][9] = "Diafragma";
		catalogo[5][10] = "Olhos";
			
	}
		
	public static void main(String[] args) {
		
		cadastroInicial();
		menuPrincipal();
	
	}
	
	// Menu principal
	public static void menuPrincipal() { 
		
		System.out.println("Escolha a opção:");
		System.out.println("1. Gerenciar Temas");
		System.out.println("2. Gerenciar Palavras");
		System.out.println("3. Jogar");
		System.out.println("4. Sair");
		
		String opcaoEscolhida =  ler.next();
		
		switch (opcaoEscolhida) {
		case "1": menuGerenciarTemas();
		break;
		case "2": menuGerenciarPalavras();
		break;
		case "3": jogar();
		break;
		case "4": System.exit(0);
		break;
		default: {
			System.out.println("Opção inválida, tente novamente\n");
			menuPrincipal();
		}
		break;
		}
	}
	
	// Menu Gerenciar Temas
	public static void menuGerenciarTemas() {
		
		//Menu Gerenciar Temas
		System.out.println("Escolha a opção:");
		System.out.println("1. Cadastro");
		System.out.println("2. Exclusão");
		System.out.println("3. Busca");
		
		String opcaoEscolhidaGerenciarTemas =  ler.next();
		
		switch (opcaoEscolhidaGerenciarTemas) {
		case "1": cadastroTemas();	
		break;
		case "2": exclusaoTemas();
		break;
		case "3": buscaTemas();
		break;
		default: {
			System.out.println("Opção inválida, tente novamente\n");
			menuGerenciarTemas();
		}
		break;
		}
	}
	
	static int aux=1;
	
	// Op��es Gerenciar Temas
	public static void cadastroTemas() {
		
		System.out.println("Insira aqui o nome do novo Tema:");
		if(aux==1) {
			ler.nextLine();
		}
		String novoTema = ler.nextLine();
		
		if(busca_check(novoTema)) {
			System.out.println("Este tema já está cadastrado, tente cadastrar outro tema\n");
			aux=0;
			cadastroTemas();
		}else{
			int indexPrimeiroNull = primeiroTemaNull();
			catalogo[indexPrimeiroNull][0] = novoTema;
			System.out.println("Tema cadastrado com sucesso\n");
			aux=1;
			menuPrincipal();
		}
		
	}

	public static void buscaTemas() {
		
		System.out.println("Digite o tema que deseja buscar:");
		boolean mid_bool = false;		
		String valor_buscado = ler.next();
		
		for (int row = 0; row<51;row++) {		
			if(String.valueOf(catalogo[row][0]).equals(valor_buscado)) {
				mid_bool = true;
				break;
			}else {
				mid_bool = false;
			}
		}
		
		if(mid_bool == true) {
			System.out.println("O tema "+valor_buscado+" já está cadastrado\n");
			menuPrincipal();
		}else {
			System.out.println("O tema "+valor_buscado+" não foi encontrado\n");
			menuPrincipal();
		}
	}
	
	public static void exclusaoTemas() {
		displayTemasNotNull();
		
		System.out.println("Insira o nome do tema que deseja excluir:");
		String temaAexcluir = ler.next();
		
		if(!busca_check(temaAexcluir)) {
			System.out.println("Este tema não existe\n");
			exclusaoTemas();
		}else {
			if(!temaVazio(temaAexcluir)) {
				System.out.println("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.\n");
				menuPrincipal();
			}else {
				catalogo[retornaLinhaTema(temaAexcluir)][0] = null;
				System.out.println("Tema excluído com sucesso\n");
				menuPrincipal();
			}
		}
	}
	

	// Assets Gerenciar Temas
	public static void displayTemasNotNull() { 
		
		System.out.println("| Temas |");
		for (int row = 0;row<51;row++) {
			if(!String.valueOf(catalogo[row][0]).equals("null"))
			System.out.print(catalogo[row][0]+"\n");
		}
	}
	
	public static void display() { 
		
		System.out.println("| Temas |\t|Palavras|");
		for (int row = 0;row<10;row++) {
			for(int col = 0;col<10;col++) {
				System.out.print(catalogo[row][col]+"\t");
				
			}
			System.out.println("\n");
		}
	}
	
	public static boolean busca_check(String tema) {
		boolean mid_bool;
		
		for (int row = 0; row<51;row++) {
			if(String.valueOf(catalogo[row][0]).equals(tema)) {
				mid_bool = true;
				return mid_bool;
			}else {
				mid_bool = false;
			}
		}
		
		return false;
	}
	
	public static int primeiroTemaNull() {
		
		
		for(int row = 0;row < 51;row++) {
			if(String.valueOf(catalogo[row][0]).equals("null")) {
				return row;
			}
		}
		return 0;
	}
	
	public static boolean temaVazio(String tema) {
		for(int col = 1;col<51;col++) {
			if(!String.valueOf(catalogo[retornaLinhaTema(tema)][col]).equals("null")) {
				return false;
			}
		}
		return true;
	}
	
	public static int retornaLinhaTema(String tema) {
		
		for(int row = 0;row<51;row++) {
			if(String.valueOf(catalogo[row][0]).equals(tema)) {
				return row;
			}
		}
		return 0;
	}
	
	// Menu Gerenciar Palavras
	public static void menuGerenciarPalavras() {
		
		//Menu Gerenciar Temas
		System.out.println("Escolha a opção:");
		System.out.println("1. Cadastro");
		System.out.println("2. Exclusão");
		System.out.println("3. Busca");
		System.out.println("4. Listagem");
		
		String opcaoEscolhidaGerenciarPalavras =  ler.next();
		
		switch (opcaoEscolhidaGerenciarPalavras) {
		case "1": cadastroPalavras();
		break;
		case "2": exclusaoPalavras();
		break;
		case "3": buscaPalavras();
		break;
		case "4": listagem();
		break;
		default: {
			System.out.println("Opção inválida, tente novamente\n");
			menuGerenciarPalavras();
		}
		break;
		}
	}
	
	static int aux2 = 1;
	
	public static void cadastroPalavras() {
		System.out.println("Escolha o tema para cadastrar a Palavra");
		displayTemasNotNull();
		
		if(aux2==1) {
			ler.nextLine();
		}
		String temaEscolhido = ler.nextLine();
		if(!busca_check(temaEscolhido)) {
			System.out.println("Tema inválido, tente novamente\n");
			aux2=0;
			cadastroPalavras();
		}
		
		System.out.println("Digite a palavra a ser inserido no tema "+temaEscolhido);
		String novapalavra = ler.nextLine();
		
		if(busca_check_palavras(temaEscolhido, novapalavra)) {
			System.out.println("Esta palavra já está cadastrada neste tema, tente novamente\n");
			aux2=0;
			cadastroPalavras();
		}else {
			catalogo[retornaLinhaTema(temaEscolhido)][primeiraPalavraNull(temaEscolhido)] = novapalavra;
			System.out.println("Palavra cadastrada com sucesso !!\n");
			aux2 = 1;
			menuPrincipal();	
		}
		
	}
	
	static int aux3=1;
	
	public static void exclusaoPalavras() {
		System.out.println("Escolha o tema para excluir as Palavras");
		displayTemasNotNull();
		
		if(aux3==1) {
			ler.nextLine();
		}
		String temaEscolhido = ler.nextLine();
		
		System.out.println("Insira o nome da palavra que deseja excluir:");
		String palavraAexcluir = ler.nextLine();
		
		if(!busca_check_palavras(temaEscolhido, palavraAexcluir)) {
			System.out.println("Esta palavra não está no tema selecionado.\n");
			aux3=0;
			exclusaoPalavras();
		}else {
			catalogo[retornaLinhaTema(temaEscolhido)][colunaPalavra(temaEscolhido, palavraAexcluir)] = null;
			System.out.println("palavra excluída com sucesso\n");
			aux=1;
			menuPrincipal();
		
		}
		
	}
	
	public static void buscaPalavras() {
		System.out.println("Insira a palavra que deseja buscar:");
		ler.nextLine();
		String palavraBuscada = ler.nextLine();
		boolean mid_bool = false;
		int row_mid = 0; 
		
		loop1 : for(int row = 0;row<51;row++) {
			for(int col = 1;col<51;col++) {
				if(String.valueOf(catalogo[row][col]).equals(palavraBuscada)) {
					mid_bool = true;
					row_mid = row;
					break loop1;
				}else {
					mid_bool = false;
				}
			}	
		}
		
		if(mid_bool == true) {
			System.out.println("Palavra encontrada no tema "+ catalogo[row_mid][0] + "\n");
			menuPrincipal();
		}else {
			System.out.println("Palavra não encontrada \n");
			menuPrincipal();
		}
		
	}
	
	static int aux4 = 1;
	public static void listagem() {
		System.out.println("Escolha o tema para listar as palavras");
		displayTemasNotNull();
		
		if(aux4==1) {
			ler.nextLine();
		}
		String temaEscolhido = ler.nextLine();
		if(busca_check(temaEscolhido)) {
			displayPalavrasNotNull(temaEscolhido);
			aux4=1;
		}else {
			System.out.println("Tema inválido, tente novamente\n");
			aux4 =0;
			listagem();
		}
		
	}
	
	public static void displayPalavrasNotNull(String tema) { 
		
		System.out.println("| Palavras |");
		for (int col = 1;col<51;col++) {
			if(!String.valueOf(catalogo[retornaLinhaTema(tema)][col]).equals("null"))
			System.out.print(catalogo[retornaLinhaTema(tema)][col]+"\n");
		}
		System.out.println("\n");
		menuPrincipal();
	}
	
	public static boolean busca_check_palavras(String tema, String palavra) {
		boolean mid_bool;
		
		for (int col = 0; col<51;col++) {
			if(String.valueOf(catalogo[retornaLinhaTema(tema)][col]).equals(palavra)) {
				mid_bool = true;
				return mid_bool;
			}else {
				mid_bool = false;
			}
		}
		
		return false;
	}
	
	public static int primeiraPalavraNull(String tema) {
		
		
		for(int col = 0;col < 51;col++) {
			if(String.valueOf(catalogo[retornaLinhaTema(tema)][col]).equals("null")) {
				return col;
			}
		}
		return 0;
	}

	public static int colunaPalavra(String tema, String palavra) {
		
		for(int col = 0;col<51;col++) {
			if(String.valueOf(catalogo[retornaLinhaTema(tema)][col]).equals(palavra)) {
				return col;
			}
		}
		return 0;
	}
	
	static int erros = 0;
	static String letrasTentadas[] = new String[100];
	
	
	static int aux5 = 1;
	public static void jogar() {
		System.out.println("Selecione o tema:");
		displayTemasNotNull();
		
		if(aux5==1) {
			ler.nextLine();
		}
		String temaSelecionado = ler.nextLine();
		if(!busca_check(temaSelecionado)) {
			System.out.println("Tente um tema já cadastrado\n");
			aux5=0;
			jogar();
		}
		if(temaVazio(temaSelecionado)) {
			System.out.println("Tema não possui palavras cadastradas, tente outro tema\n");
			aux5 = 0;
			jogar();
		}
		erros = 0;
		limpaLista(letrasTentadas);
		String[][] listaPalavras = criaListaPalavras(temaSelecionado);
		displayListaPalavras(listaPalavras, listaPalavras.length);
		int i = 0;
		loopwhile : while (erros<5) {
			
			System.out.println("====================");
			System.out.println((int)(i+1) +"°" + " rodada");
			System.out.println("====================");
			System.out.println("Insira uma letra:");
			String letra = ler.next();
			if(buscaLetraTentada(letrasTentadas, letra)) {
				System.out.println("Tente outra letra");
			}else {
				if(checkIsPalavra(listaPalavras, letra)) {
					System.out.println("Parabéns, você encontrou uma letra!!\n");
					System.out.println("Erros : " + erros);
					letrasTentadas[primeiraLetraNull(letrasTentadas)] = letra;
					for(int j=0;j<listaPalavras.length; j++) {
						if(String.valueOf(listaPalavras[0][j]).equals(letra)) {
							listaPalavras[1][j] = letra;
							displayListaPalavras(listaPalavras, listaPalavras.length);
						}
					}
					if(!checkIsPalavra2(listaPalavras, "_")) {
						System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente? [S/N]");
						aux5=1;
						String option = ler.next();
						switch(option) {
						case "S": jogar();
						break loopwhile;
						case "N": menuPrincipal();
						break loopwhile;
						}
					};
				}else {
					System.out.println("Letra não está na palavra\n");
					erros++;
					System.out.println("Erros :" + erros);
					letrasTentadas[primeiraLetraNull(letrasTentadas)] = letra;
					displayListaPalavras(listaPalavras, listaPalavras.length);
				}
			}
			i++;
		}
		System.out.println("Você perdeu! Deseja Deseja jogar novamente? [S/N]");
		aux=1;
		String option2 = ler.next();
		switch(option2) {
		case "S": jogar();
		break;
		case "N": menuPrincipal();
		default: menuPrincipal();
		break;
		}
		
	}
	
	public static void displayListaPalavras(String lista[][], int tamanho) {
		/*
		 * System.out.println(); for(int i=0;i<tamanho;i++) {
		 * System.out.print(lista[0][i]+ " "); }
		 */
		System.out.println("\n");
		for(int i=0;i<tamanho;i++) {
			System.out.print(lista[1][i]+ " ");
		}
		System.out.println("\n");
	}
	
	public static boolean checkIsPalavra(String lista[][], String letra) {
		boolean mid_bool;
		
		for(int i =0; i<lista.length;i++) {
			if(String.valueOf(lista[0][i]).equals(letra)) {
				mid_bool = true;
				return mid_bool;
			}else {
				mid_bool = false;
			}
		}
		return false;
	}
	
	public static boolean checkIsPalavra2(String lista[][], String letra) {
		boolean mid_bool;
		
		for(int i =0; i<lista.length;i++) {
			if(String.valueOf(lista[1][i]).equals(letra)) {
				mid_bool = true;
				return mid_bool;
			}else {
				mid_bool = false;
			}
		}
		return false;
	}
	
	public static String[][]  criaListaPalavras(String temaSelecionado) {
		int num;
		String palavraSelecionada;
		
		do {
			num = (int)(Math.random()*50);
			palavraSelecionada = catalogo[retornaLinhaTema(temaSelecionado)][num];
		}while(String.valueOf(catalogo[retornaLinhaTema(temaSelecionado)][num]).equals("null") || (num == 0));
		/* System.out.println(palavraSelecionada); */
	
		String listaPalavra[][] = new String[palavraSelecionada.length()][palavraSelecionada.length()];
		for(int letra = 0;letra < palavraSelecionada.length(); letra++) {
			listaPalavra[0][letra] = String.valueOf(palavraSelecionada.charAt(letra));
			if(listaPalavra[0][letra].contains(" ")) {
				listaPalavra[1][letra] = " ";
			}else {
				listaPalavra[1][letra] = "_";
			}
		}
		
		return listaPalavra;
	}
	
	public static int primeiraLetraNull(String letrasTentadas[]) {
		
		
		for(int i = 0;i < 100;i++) {
			if(String.valueOf(letrasTentadas[i]).equals("null")) {
				return i;
			}
		}
		return 0;
	}
	
	public static void limpaLista(String letrasTentadas[]) {
		for(int i=0;i<100;i++ ) {
			letrasTentadas[i] = null;
		}
	}
	
	public static boolean buscaLetraTentada(String[] lista, String letra) {
		boolean mid_bool;
		
		for (int i = 0; i<100;i++) {
			if(String.valueOf(lista[i]).equals(letra)) {
				mid_bool = true;
				return mid_bool;
			}else {
				mid_bool = false;
			}
		}
		
		return false;
	}
	
	
}
