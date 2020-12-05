public class Arvore
{
	private No Raiz;

	public No getRaiz() {
		return this.Raiz;
	}

	public void incluir (char Num, int Qtos) {
		incluir(new No(Num, Qtos));
	}

	public void incluir (No Novo) {
		if (Novo==null) return;
		if (this.Raiz == null)
			this.Raiz = Novo;

		else
			incluir(this.Raiz, Novo);
	}

	private void incluir (No Raiz, No Novo)
	{
		if (Novo.getInfo() > Raiz.getInfo())
		{
			if (Raiz.getDir() == null)
				Raiz.setDir(Novo);

			else
				incluir (Raiz.getDir(), Novo);
		}
		else
		{
			if (Raiz.getEsq() == null)
				Raiz.setEsq(Novo);

			else
				incluir (Raiz.getEsq(), Novo);
		}
	}

    public int somaValores(){
          return somaTudo(this.Raiz);
    }

    private int somaTudo(No Raiz){
        if (Raiz==null) return 0;
        if ((Raiz.getEsq()==null) && (Raiz.getDir()==null))  // Folha
            return Raiz.getOcorrencia();

        return
               somaTudo(Raiz.getEsq()) +
               somaTudo(Raiz.getDir()) + Raiz.getOcorrencia();
    }


    public String toString(){
        return visita(this.Raiz);
    }

    private String visita(No Raiz){  // InOrdem

         if (Raiz == null) return "";

         return visita(Raiz.getEsq()) + " " +
                Raiz.getInfo() + " " +
                visita(Raiz.getDir());
    }
}