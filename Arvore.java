import java.util.ArrayList;
import java.util.List;

// 19351
// Carolina Moraes Quiterio
// Desenvolvimento de sistemas - vespertino
// Estrutura de dados 2

public class Arvore implements Comparable<Arvore>
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

 	public int quantosNosTenho(){
         return qtos(this.raiz);
     }

     private int qtos(No raiz){   // quantas caixinhas tenho na arvore
         if (raiz == null) return 0;

         return 1  + qtos(raiz.getDir()) + qtos(raiz.getEsq());
     }

    public String toString(){
        return visita(this.raiz);
    }

    private String visita(No raiz){  // InOrdem

         if (raiz == null) return "";

         return visita(raiz.getEsq()) + " " + "\n"+
                raiz.getInfo() + " " +
                visita(raiz.getDir()) ;
    }

	public int compareTo(Arvore ar) //compareTo para que seja possivel ordernar a lista de arvores (List<Arvore>)
	{
    	final int oc  = Integer.compare(this.raiz.getInfo().getQuantos(), ar.getRaiz().getInfo().getQuantos());

    	if(oc != 0 )
            return oc;

    	return Integer.compare(this.getRaiz().getInfo().getCaracter(), ar.getRaiz().getInfo().getCaracter());
    }
    List<No> listaBinario = new ArrayList<No>();
 	public List<No> criarBinario(){

        binario(this.raiz,"");

        return listaBinario;
    }

    private void binario(No raiz, String s){

        if (raiz.getEsq()== null && raiz.getDir() == null) {
                listaBinario.add(new No(raiz.getInfo().getCaracter(),s));
                return;
        }
		if(raiz.getEsq() != null)
       		 binario(raiz.getEsq(), s + "0");
        if(raiz.getDir() != null)
			binario(raiz.getDir(), s + "1");
    }

}