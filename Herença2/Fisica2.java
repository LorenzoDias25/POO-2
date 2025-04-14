
package heranca2;

public abstract class Fisica2 extends Pessoa2 {
    String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Fisica2(){
    }
    
    public Fisica2(String cpf){
        this.cpf = cpf;
    }
    
    public Fisica2(String nome, String endereco, String cpf){
        super(nome,endereco);
        this.cpf = cpf;
    }
}
