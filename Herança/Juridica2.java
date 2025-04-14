
package lorenzodias;


public class Juridica2 extends Pessoa2{
    String cnpj;
    String tipo; 

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Juridica2(){
    
    }
    
    public Juridica2(String cnpj, String tipo){
        this.cnpj = cnpj;
        this.tipo = tipo;
    }
    
    public Juridica2(String nome, String endereco, String cnpj, String tipo){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.tipo = tipo;
    }
}
