public class No
{
	private char Info;
	private int Ocorrencia;
	private No Esq, Dir;
	private No Ant, Prox;

	public No(char I, int O)
	{
		this.Info = I;
		this.Ocorrencia = O;
		this.Esq = this.Dir = null;
		this.Ant = this.Prox = null;
	}

	public void setInfo(char I){ this.Info = I;}
	public void setOcorrencia(int I){ this.Ocorrencia = I;}
	public void setDir(No D){ this.Dir = D;}
	public void setEsq(No E){ this.Esq = E;}
	public void setAnt(No A){ this.Ant = A;}
	public void setProx(No P){ this.Prox = P;}

	public char getInfo() { return this.Info;}
	public int getOcorrencia() {return this.Ocorrencia;}
	public No  getDir() { return this.Dir;}
	public No  getEsq() { return this.Esq;}
	public No  getAnt() { return this.Ant;}
	public No  getProx() { return this.Prox;}

	public String toString()
	{
		return""+getInfo();
	}

}