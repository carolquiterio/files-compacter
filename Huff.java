//
// 19351
// CAROLINA MORAES QUITERIO
// DESENVOLVIMENTO DE SISTEMAS - VESPERTINO
// ESTRUTURA DE DADOS 2
//

import java.util.List;
import java.util.*;

public class Huff
{

	public static void compactar(String arqEntrada, String arqSaida) throws Exception
	{
		HArquivo a = new HArquivo(); //classe com leitura de dados e metodo de gerar tabela de ocorrencia
		List<Ocorrencia> lista = new ArrayList();

		lista = a.gerarTabelaDeOcorrencia("teste.txt"); //gera a tabela de ocorrencia

		Collections.sort(lista); // ordena a lista

		Arvore ar = new Arvore();

		for(int i=0; i<lista.size();i++)
		{
			ar.incluir(lista.get(i).getCaracter(), lista.get(i).getQuantos()); //gera arvore a partir da tabela
		}

		System.out.println(ar);


		////////TabelaHuff tabela = Huff.gerarTabela(textoDoArquivo);
		////////Arvore arvHuff = Huff.geraArvore(tabela);


		//gerar estrutura com caracter e seu equivalente (codigos binarios)
		// tabela de conversao recebendo arvore como parametro


		//releitura do texto convertendo pra codigo binario utilizando o bitset
		// e gerar o arquivo final (meuTexto, arqSaida, tabelaBinaria)
		///////// gerarArquivoCompactado(meutexto, tabelaConv, arqSaida)
	}

	//public String void descompactar ()

}