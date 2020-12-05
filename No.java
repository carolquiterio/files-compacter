public class No
{
	private Ocorrencia info;

	private No Esq, Dir;
	private No Ant, Prox;

	public No(Ocorrencia I)
	{
		this.info = I;

		this.Esq = this.Dir = null;
		this.Ant = this.Prox = null;
	}

	public void setInfo(Ocorrencia I){ this.info = I;}

	public void setDir(No D){ this.Dir = D;}
	public void setEsq(No E){ this.Esq = E;}
	public void setAnt(No A){ this.Ant = A;}
	public void setProx(No P){ this.Prox = P;}

	public Ocorrencia getInfo() { return this.info;}

	public No  getDir() { return this.Dir;}
	public No  getEsq() { return this.Esq;}
	public No  getAnt() { return this.Ant;}
	public No  getProx() { return this.Prox;}

	public String toString()
	{
		return""+getInfo();
	}

}