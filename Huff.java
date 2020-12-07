// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

import java.util.List;
import java.util.*;

public class Huff
{

	public static void compactar(String arqEntrada, String arqSaida) throws Exception
	{
		HArquivo a = new HArquivo(); //classe com leitura de dados e metodo de gerar tabela de ocorrencia
		List<Arvore> lista = new ArrayList();

		lista = a.gerarTabelaDeOcorrencia("teste.txt"); //gera a tabela de ocorrencia

		Collections.sort(lista); // ordena a lista
		Collections.reverse(lista);  //coloca a lista do maior para o menor
		//System.out.println(lista);
		System.out.println(lista);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Arvore ar = new Arvore();

		ar = geraArvore(lista);
		//System.out.println(lista);
		System.out.println(ar);

		geraCodigoBinario(ar);

		////////TabelaHuff tabela = Huff.gerarTabela(textoDoArquivo);
		////////Arvore arvHuff = Huff.geraArvore(tabela);


		//gerar estrutura com caracter e seu equivalente (codigos binarios)
		// tabela de conversao recebendo arvore como parametro


		//releitura do texto convertendo pra codigo binario utilizando o bitset
		// e gerar o arquivo final (meuTexto, arqSaida, tabelaBinaria)
		///////// gerarArquivoCompactado(meutexto, tabelaConv, arqSaida)
	}

	//public String void descompactar ()

	private static List<String> geraCodigoBinario(Arvore a)  // usei o tipo ocorrencia pois o caracter continua e o codigo binario e um int
	{
		List<String> lista = new ArrayList();
		String codigo = "";

		int numeroDeNos = a.quantosNosTenho();

		for (int i =0; i< numeroDeNos; i++ )
		{
			//System.out.println(a.getRaiz());

			if(a.getRaiz().getEsq() != null)
				codigo = codigo + "1";
			else if (a.getRaiz().getDir() != null)
				codigo = codigo + "0";

			lista.add(codigo);
		}

		return lista;
	}

	private static Arvore geraArvore(List<Arvore> listaDeArvores)
	{
		while (listaDeArvores.size() > 1)
		{
            Arvore ultima = listaDeArvores.get(listaDeArvores.size()-1);  //guardo o ultimo e o penultimo elemento
            listaDeArvores.remove(listaDeArvores.size()-1);

            Arvore penultimo = listaDeArvores.get(listaDeArvores.size()-1);
            listaDeArvores.remove(listaDeArvores.size()-1);

            int soma = ultima.getRaiz().getInfo().getQuantos() + penultimo.getRaiz().getInfo().getQuantos();

            Arvore aux = new Arvore();

            aux.incluir(' ',soma);

            escolheUmaDirecao(aux, ultima, penultimo);

            listaDeArvores.add(aux);
            Collections.sort(listaDeArvores);
			Collections.reverse(listaDeArvores);
        }

         return listaDeArvores.get(0);
	}

	private static void escolheUmaDirecao(Arvore f,Arvore ultimo,Arvore penultimo) //seta a direcao certa para ser usada em cada caso especifico
	{
		if(ultimo.getRaiz().getInfo().getCaracter() >= penultimo.getRaiz().getInfo().getCaracter())
        {
            f.getRaiz().setDir(ultimo.getRaiz());
            f.getRaiz().setEsq(penultimo.getRaiz());

        }
        else if(ultimo.getRaiz().getInfo().getCaracter() <= penultimo.getRaiz().getInfo().getCaracter())
        {
            f.getRaiz().setEsq(ultimo.getRaiz());
            f.getRaiz().setDir(penultimo.getRaiz());

        }
        else if(ultimo.getRaiz().getInfo().getQuantos() >= penultimo.getRaiz().getInfo().getQuantos())
        {
            f.getRaiz().setDir(ultimo.getRaiz());
            f.getRaiz().setEsq(penultimo.getRaiz());
        }
        else if(ultimo.getRaiz().getInfo().getQuantos() <= penultimo.getRaiz().getInfo().getQuantos())
        {
            f.getRaiz().setEsq(ultimo.getRaiz());
            f.getRaiz().setDir(penultimo.getRaiz());
        }
    }

}