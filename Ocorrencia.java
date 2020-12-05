public class Ocorrencia implements Comparable<Ocorrencia>
{
	private char caracter;
	private int quantos;

	public Ocorrencia(char caracter, int quantos)
	{
		this.setCaracter(caracter);
		this.setQuantos(quantos);
	}

	public Ocorrencia( int quantos)
	{
		this('\0', quantos);
	}

	public char getCaracter ()
	{
		return this.caracter;
	}

	public int getQuantos ()
	{
		return this.quantos;
	}

	public void setCaracter (char caracter)
	{
		this.caracter = caracter;
	}


	public void setQuantos (int quantos)
	{
		this.quantos = quantos;
	}

	public String toString()
	{
		String ret = "";

		ret = "Quantos: " + this.quantos + "   Caracter: " + this.caracter;

		return ret;
	}

	public int compareTo(Ocorrencia oc)
    {
		if (this.quantos < oc.quantos)
			return -666;

		 if (this.quantos > oc.quantos)
			return 666;

	 	return 0;
	 }

}