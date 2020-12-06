import java.io.*;
import java.util.List;
import java.util.*;

public class HArquivo
{
	private static List<Ocorrencia> oc;

	public HArquivo() throws Exception
	{
		this.oc = new ArrayList<Ocorrencia> ();
	}

	public static List gerarTabelaDeOcorrencia(String nomeDoArquivo) throws Exception
	{
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
				oc.add(new Ocorrencia(((char)i), contaOcorrencia[i]));
			}
		}
		System.out.println("oii");
		return oc;
	}
}