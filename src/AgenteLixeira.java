import java.util.ArrayList;
import java.util.List;

public class AgenteLixeira {

    public String nome;
    public int capacidade;
    public String tipoLixo;
    public List<String> listaDeDetritos= new ArrayList<>();

    public AgenteLixeira(String nome, String tipoLixo) {
        this.nome = nome;
        this.capacidade = 0;
        this.tipoLixo = tipoLixo;
    }

    public Boolean isCheio(){

        if (this.capacidade >= 12){

            return true;
        }

        return false;
    }

    public Boolean testaTipoLixo(AgenteLixeira lixeira){

        for(String detrito: listaDeDetritos){

            if(detrito != lixeira.getTipoLixo()){

                return false;

            }

        }

        return true;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoLixo() {
        return tipoLixo;
    }

    public void setTipoLixo(String tipoLixo) {
        this.tipoLixo = tipoLixo;
    }

    public List<String> getListaDeDetritos() {
        return listaDeDetritos;
    }

    public void setListaDeDetritos(List<String> listaDeDetritos) {
        this.listaDeDetritos = listaDeDetritos;
    }
}
