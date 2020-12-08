// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class AppHuff {

	public static void main (String[] args) {

		try
		{
			Huff.compactar("teste.txt", "novo.huf");
			//Huff.descompactar("novo.huf", "descompactado.txt");

		}

		catch (Exception e)
		{
			System.out.println (e.getMessage());
        }
	}

}