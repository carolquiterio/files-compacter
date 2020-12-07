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
		Collections.reverse(lista);

		Arvore ar = new Arvore();
		int tamanhoDaLista = lista.size();
		//for(int i=0; i<tamanhoDaLista;i++)
		//{
		//	ar.incluir(lista.get(i).getInfo().getCaracter(), lista.get(i).getInfo().getQuantos()); //gera arvore a partir da tabela
		//}

		int tamanhoDaArvre = ar.quantosNosTenho();
		//geraCodigoBinario(ar);

		////////TabelaHuff tabela = Huff.gerarTabela(textoDoArquivo);
		////////Arvore arvHuff = Huff.geraArvore(tabela);


		//gerar estrutura com caracter e seu equivalente (codigos binarios)
		// tabela de conversao recebendo arvore como parametro


		//releitura do texto convertendo pra codigo binario utilizando o bitset
		// e gerar o arquivo final (meuTexto, arqSaida, tabelaBinaria)
		///////// gerarArquivoCompactado(meutexto, tabelaConv, arqSaida)
	}

	//public String void descompactar ()

	/*private static List<Arvore> geraCodigoBinario(Arvore a)  // usei o tipo ocorrencia pois o caracter continua e o codigo binario e um int
	{
		List<Arvore> lista = new ArrayList();
		String codigo = "";

		//while (a.getRaiz().getEsq() != "" && a.getRaiz().getDir() != "")
		for (int i =0; i< 10; i++)
		{
			System.out.println(a.getRaiz());
			if(a.getRaiz.getEsq() != null)
				codigo = cogido + "1";
		}

		return lista;
	}*/

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