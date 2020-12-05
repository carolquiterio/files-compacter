//
// 19351
// CAROLINA MORAES QUITERIO
// DESENVOLVIMENTO DE SISTEMAS - VESPERTINO
// ESTRUTURA DE DADOS 2
//

public class Huff
{

	public static void compactar(String arqEntrada, String arqSaida) throws Exception
	{
		HArquivo a = new HArquivo(); //leitura do dados

		a.gerarTabelaDeOcorrencia("teste.txt"); //gerar tabela de ocorrencia


		//gerar arvore a partir da tabela
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