public class Arvore
{
	private No raiz;

	public No getRaiz() {
		return this.raiz;
	}

	public void incluir (char car, int qtos) {
		incluir(new No(new Ocorrencia(car, qtos)));
	}

	public void incluir (No novo) {
		if (novo==null) return;
		if (this.raiz == null)
			this.raiz = novo;

		else
			incluir(this.raiz, novo);
	}

	private void incluir (No raiz, No novo)
	{
		if (novo.getInfo().getCaracter() > raiz.getInfo().getCaracter())
		{
			if (raiz.getDir() == null)
				raiz.setDir(novo);

			else
				incluir (raiz.getDir(), novo);
		}
		else
		{
			if (raiz.getEsq() == null)
				raiz.setEsq(novo);

			else
				incluir (raiz.getEsq(), novo);
		}
	}

    public int somaValores(){
          return somaTudo(this.raiz);
    }

    private int somaTudo(No raiz){
        if (raiz==null) return 0;
        if ((raiz.getEsq()==null) && (raiz.getDir()==null))  // Folha
            return raiz.getInfo().getQuantos();

        return
               somaTudo(raiz.getEsq()) +
               somaTudo(raiz.getDir()) + raiz.getInfo().getQuantos();
    }


    public String toString(){
        return visita(this.raiz);
    }

    private String visita(No raiz){  // InOrdem

         if (raiz == null) return "";

         return visita(raiz.getEsq()) + " " +
                raiz.getInfo() + " " +
                visita(raiz.getDir());
    }
}