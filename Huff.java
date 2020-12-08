import java.util.*;
import java.io.*;

// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class Huff
{
	private static BitSet elementoBitSet;
	private static HArquivo arq;

	public static void compactar(String arqEntrada, String arqSaida) throws Exception
	{
		FileInputStream     arquivoFisico;
        BufferedInputStream buffReader;
        DataInputStream     data;

        arquivoFisico = new FileInputStream("teste.txt");
        buffReader = new BufferedInputStream(arquivoFisico);
        data = new DataInputStream(buffReader);

        byte vetByte[];
        vetByte = new byte[arquivoFisico.available()];
        int[] ocorrencias = new int[100000];

		List<No> listaBinaria;

		arq = new HArquivo(); //classe com leitura de dados e metodo de gerar tabela de ocorrencia
		List<Arvore> lista = new ArrayList();

		lista = arq.gerarTabelaDeOcorrencia(data, vetByte); //gera a tabela de ocorrencia

		Collections.sort(lista); // ordena a lista
		Collections.reverse(lista);  //coloca a lista do maior para o menor
		Arvore ar = new Arvore();

		ar = geraArvore(lista);  //gera a arvore a partir da lista de arvores

		listaBinaria = ar.criarBinario(); //gerar estrutura com caracter e seu equivalente (codigos binarios)

  		ObjectOutputStream outputStream = null;
        outputStream = new ObjectOutputStream(new FileOutputStream(arqSaida));  //cria um arquivo para passar de paraetro e colocar o texto compactado


		arq.geraArquivoECompacta(outputStream, listaBinaria, ar, vetByte ); // gerar o arquivo final

	}

	private static Arvore geraArvore(List<Arvore> listaDeArvores)  //gera a estrutura da arvore
	{
		while (listaDeArvores.size() > 1)
		{
            Arvore ultima = listaDeArvores.get(listaDeArvores.size()-1);
            listaDeArvores.remove(listaDeArvores.size()-1);

            Arvore penultimo = listaDeArvores.get(listaDeArvores.size()-1);          //guardo o ultimo e o penultimo elemento
            listaDeArvores.remove(listaDeArvores.size()-1);

            int soma = ultima.getRaiz().getInfo().getQuantos() + penultimo.getRaiz().getInfo().getQuantos(); //guarda a soma da ocorrencia para gerar um no com folhas

            Arvore aux = new Arvore();

            aux.incluir(' ',soma);   //inclui na arvore auxilia um no com apenas a soma (nos q nao sao folhas)

            escolheUmaDirecao(aux, ultima, penultimo);  //define se é pra criar um novo no na dir esq ou nao

            listaDeArvores.add(aux);
            Collections.sort(listaDeArvores);
			Collections.reverse(listaDeArvores);
        }

         return listaDeArvores.get(0);
	}

	private static void escolheUmaDirecao(Arvore arv, Arvore ultimo, Arvore penultimo) //seta a direcao certa para ser usada em cada caso especifico
	{
		if(ultimo.getRaiz().getInfo().getCaracter() >= penultimo.getRaiz().getInfo().getCaracter())
        {
            arv.getRaiz().setDir(ultimo.getRaiz());
            arv.getRaiz().setEsq(penultimo.getRaiz());
        }
        else if(ultimo.getRaiz().getInfo().getCaracter() <= penultimo.getRaiz().getInfo().getCaracter())
        {
            arv.getRaiz().setEsq(ultimo.getRaiz());
            arv.getRaiz().setDir(penultimo.getRaiz());
        }
        else if(ultimo.getRaiz().getInfo().getQuantos() >= penultimo.getRaiz().getInfo().getQuantos())
        {
            arv.getRaiz().setDir(ultimo.getRaiz());
            arv.getRaiz().setEsq(penultimo.getRaiz());
        }
        else if(ultimo.getRaiz().getInfo().getQuantos() <= penultimo.getRaiz().getInfo().getQuantos())
        {
            arv.getRaiz().setEsq(ultimo.getRaiz());
            arv.getRaiz().setDir(penultimo.getRaiz());
        }
    }
}

///////////////////////////////////////////////TENTANDO DESCOMPACTAR////////////////////////////////////////////////////
/*
	public static void descompactar(String nome, String nomeDestino) throws Exception
	{
		FileInputStream arquivo = new FileInputStream(nome);


            StringBuilder s = new StringBuilder();
}

  private static String descompactaComRecursao(No raiz,String binario){
      return  desc(raiz, binario, "");                                  //para usar em cada parte especifica
    }

      private static String desc(No raiz, String binario, String frase)
      {

        No aux = raiz;
        for(int i = 0; i < binario.length();i++){
            if(binario.charAt(i) == '0')
                aux = aux.getEsq();

            if(binario.charAt(i) == '1'){
                aux =  aux.getDir();
            }
            if(aux.getDir() == null && aux.getEsq() == null){
                frase += aux.getInfo().getCaracter();
                aux = raiz;
            }

        }
        return frase;
	}
	*/