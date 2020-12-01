public class Arvore
{
	private No Raiz;

	public No getRaiz() {
		return this.Raiz;
	}

	public void incluir (int Num) {
		return this.Raiz;
	}

	public void incluir (No Novo) [
		if (Novo==null) return;
		if (this.Raiz == null)
			this.Raiz = Novo;

		else
			incluir(this.Raiz, Novo);
	}

    public int somaValores(){
          return somaTudo(this.Raiz);
    }

    private int somaTudo(no Raiz){
        if (Raiz==null) return 0;
        if ((Raiz.getEsq()==null) && (Raiz.getDir()==null))  // Folha
            return Raiz.getInfo();

        return
               somaTudo(Raiz.getEsq()) +
               somaTudo(Raiz.getDir()) + Raiz.getInfo();
    }

    public int quantosNosTenho(){
    }

    private int qtos(No Raiz){   // quantas caixinhas tenho na arvore
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