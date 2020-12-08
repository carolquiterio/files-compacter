import java.util.List;
import java.util.*;
import java.io.*;

// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class Huff
{
	private static BitSet elementoBitSet;
	private static List<No> listaBinaria;
	private static HArquivo arq;

	public static void compactar(String arqEntrada, String arqSaida) throws Exception
	{
		arq = new HArquivo(); //classe com leitura de dados e metodo de gerar tabela de ocorrencia
		List<Arvore> lista = new ArrayList();

		lista = arq.gerarTabelaDeOcorrencia("teste.txt"); //gera a tabela de ocorrencia

		Collections.sort(lista); // ordena a lista
		Collections.reverse(lista);  //coloca a lista do maior para o menor
		Arvore ar = new Arvore();

		ar = geraArvore(lista);  //gera a arvore a partir da lista de arvores

		listaBinaria = ar.criarBinario(); //gerar estrutura com caracter e seu equivalente (codigos binarios)

		//chamaBitSetECompacta();
  			 ObjectOutputStream outputStream = null;
        outputStream = new ObjectOutputStream(new FileOutputStream("saida.huf"));

		//System.out.println(arq.getVetByte());
		//arq.geraArquivoDeSaida(arqSaida, elementoBitSet);
		arq.geraArquivoECompacta(outputStream, listaBinaria, ar );
		//releitura do texto convertendo pra codigo binario utilizando o bitset
		// e gerar o arquivo final (meuTexto, arqSaida, tabelaBinaria)
		///////// gerarArquivoCompactado(meutexto, tabelaConv, arqSaida)
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

	private static void escolheUmaDirecao(Arvore f, Arvore ultimo, Arvore penultimo) //seta a direcao certa para ser usada em cada caso especifico
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

	private static void chamaBitSetECompacta()
	{
		elementoBitSet = new BitSet();

 		int cont = 0;
        for (char c : new String(arq.getVetByte()).toCharArray())
        {
            for(int i = 0; i < listaBinaria.size(); i++)
            {
                if(c == listaBinaria.get(i).getInfo().getCaracter())
                {
                    String stringBin = listaBinaria.get(i).getInfo().getStringBinaria();

                	for(int j = 0; j < stringBin.length(); j++)
                	{
                        if(stringBin.charAt(j) == '1')
                        {
                            elementoBitSet.set(cont);
                        }
                 		cont++;
                	}
                }
            }
        }
        System.out.println(elementoBitSet);
	}
}

//public String void descompactar ()

	/*&private static List<No> geraCodigoBinario(Arvore a)
	{

		List<No> lista = new ArrayList<No>();

		int numeroDeNos = a.quantosNosTenho();

		for (int i = 0; i< numeroDeNos; i++ )
		{
 			if (a.getRaiz().getEsq()== null && a.getRaiz().getDir() == null) {
                lista.add(new No(a.getRaiz().getInfo().getCaracter(),""));

        	}

			if(a.getRaiz().getEsq() != null)
			      geraCodigoBinario(a.getRaiz().getEsq(), "" + "0");
			if(raiz.getDir() != null)
				geraCodigoBinario(a.getRaiz().getDir(), "" + "1");


			//System.out.println(a.getRaiz().getInfo());
		}
		//System.out.println(lista);
		return lista;
	}*/

	/*private void binario(NoCharacter raiz,String s){



        if (raiz.getEsq()== null && raiz.getDir() == null) {
                listaBinario.add(new NoCharacter(raiz.getCharacter(),s));
                return;
        }
		if(raiz.getEsq() != null)
       		 Binario(raiz.getEsq(), s + "0");
        if(raiz.getDir() != null)
			Binario(raiz.getDir(), s + "1");
    }*/