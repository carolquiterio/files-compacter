import java.io.*;

class Programa
{
	public static void main(String Args[]) throws IOException
	{
		try
		{

			HArquivo a = new HArquivo();

			System.out.println(a.gerarTabelaDeOcorrencia("teste.txt"));

		}

		catch (Exception e)
		{
		     System.out.println (e.getMessage());
        }

	}
}