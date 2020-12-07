

// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class Ocorrencia implements Comparable<Ocorrencia>
{
	private char caracter;
	private int quantos;
	private String stringBinaria;  //só em algumas ocorrencias (so na ocorrencia para tabela binaria)

	public Ocorrencia(char caracter, int quantos)
	{
		this.setCaracter(caracter);
		this.setQuantos(quantos);
	}

	public Ocorrencia(int quantos)
	{
		this('\0', quantos);
	}

    public Ocorrencia(char caracter,String binario){
        this.caracter = caracter;
        this.stringBinaria = binario;
    }

	public char getCaracter ()
	{
		return this.caracter;
	}

	public int getQuantos ()
	{
		return this.quantos;
	}
	public String getStringBinaria() { return this.stringBinaria;}

	public void setCaracter (char caracter)
	{
		this.caracter = caracter;
	}

	public void setQuantos (int quantos)
	{
		this.quantos = quantos;
	}

	public void setStringBinaria(String s) {this.stringBinaria = s;}

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