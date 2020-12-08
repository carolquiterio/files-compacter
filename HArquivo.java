import java.io.*;
import java.util.*;

// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class HArquivo
{
	private static List<Arvore> oc;
	private static byte vetByte[];

	public byte[] getVetByte()
	{
		return this.vetByte;
	}

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

	/*public static void geraArquivoDeSaida(String nomeDoArquivoDeSaida, BitSet codigoBit) throws FileNotFoundException
	{
		try
		{
			ObjectOutputStream outputStream = null;
        	outputStream = new ObjectOutputStream(new FileOutputStream(nomeDoArquivoDeSaida));
			outputStream.writeObject(codigoBit);
		}
		catch (IOException e)
        {
            e.printStackTrace();
        }


	}*/
  public static void geraArquivoECompacta(ObjectOutputStream outputStream,List<No> listaBinaria,Arvore arvorePrincipal)
  {

        try {
                 outputStream.writeObject(arvorePrincipal.getRaiz());
            } catch (IOException e) {
                 e.printStackTrace();
            }
        int cont = 0;

         BitSet codigoBit = new BitSet();
        for (char c : new String(vetByte).toCharArray())
        {

            for(int i = 0; i < listaBinaria.size(); i++)
            {

                if(c == listaBinaria.get(i).getInfo().getCaracter())
                {
                    String caracterBinario = listaBinaria.get(i).getInfo().getStringBinaria();

                	 for(int j = 0; j < caracterBinario.length(); j++)
                	 {
                            if(caracterBinario.charAt(j) == '1')
                            {
                                    codigoBit.set(cont);
                            }
                 		cont++;
                	 }

                }
            }
        }
            System.out.println(codigoBit);
                        try {
                        //ESCREVE ESSE BIT DENTRO DO DOCUMENTO DESTINO
                        outputStream.writeObject(codigoBit);
                        } catch (IOException e) {
                         e.printStackTrace();
                        }

    }
}