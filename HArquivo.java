// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

import java.io.*;
import java.util.*;

public class HArquivo
{
	private static List<Arvore> oc;

	public HArquivo() throws Exception
	{
		this.oc = new ArrayList ();
	}

	public static List<Arvore> gerarTabelaDeOcorrencia(String nomeDoArquivo) throws Exception
	{
		// metodo para ler o arquivo e gerar a tabela de ocorrencia

		FileInputStream arquivoFisico = new FileInputStream(nomeDoArquivo);
		BufferedInputStream buffReader = new BufferedInputStream(arquivoFisico);
		DataInputStream data = new DataInputStream(buffReader);

		byte vetByte[];
		vetByte = new byte[arquivoFisico.available()];
		data.read(vetByte);

		int contaOcorrencia[] = new int[32000];

		for (char o : new String(vetByte).toCharArray())
		{
			contaOcorrencia[o]++;
		}


		for (int i=0; i< contaOcorrencia.length; i++)
		{
			if (contaOcorrencia[i]>0)
			{
				Arvore ar = new Arvore();
				ar.incluir(new No(((char)i), contaOcorrencia[i]));   // cria um no com cada caracter e sua respectiva ocorrencia
				oc.add(ar);                                  		 // insere  essa arvore em uma lista de arvores

			}
		}

		return oc;
	}
}