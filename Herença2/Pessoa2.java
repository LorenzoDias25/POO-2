
package heranca2;

public abstract class Pessoa2 {
    String nome; 
    String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public Pessoa2(){
    }
    
    public Pessoa2(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
}
