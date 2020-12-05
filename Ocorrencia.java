public class Ocorrencia
{
	private char caracter;
	private int quantos;

	public Ocorrencia(char caracter, int quantos) throws Exception
	{
		this.setCaracter(caracter);
		this.setQuantos(quantos);
	}


	public char getCaracter ()
	{
		return this.caracter;
	}

	public int getQuantos ()
	{
		return this.quantos;
	}

	public void setCaracter (char caracter) throws Exception
	{
		this.caracter = caracter;
	}


	public void setQuantos (int quantos) throws Exception
	{
		this.quantos = quantos;
	}

	public String toString()
	{
		String ret = "";

		ret = "Quantos: " + this.quantos + "   Caracter: " + this.caracter;

		return ret;
	}

}