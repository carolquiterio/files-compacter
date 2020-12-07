// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class AppHuff {

	public static void main (String[] args) {

		try
				{

					//HArquivo a = new HArquivo();

					//System.out.println(a.gerarTabelaDeOcorrencia(teste.txt"));

					/*System.out.println("Compactador de arquivos");
					System.out.println("Digite o numero da ação que deseja realizar");
					System.out.println("1 - compactar um arquivo");
					System.out.println("2 - descompactar um arquivo");*/

					Huff.compactar("teste.txt", "poesia.huf");

					//System.out.println(textoCompactado);
					//System.out.println("" + Huff.descompactar(textoCompactado));

				}

				catch (Exception e)
				{
				     System.out.println (e.getMessage());
        }
	}

}