
package lorenzodias;


public class Mulher extends Fisica2 {
    String sexo = "Feminino";

    public String getSexo() {
        return sexo;
    }
    
    public Mulher(){
    }
    
    public Mulher(String nome,String endereco, String cpf, char sexo){
        super(nome,endereco,cpf);
        //this.sexo = "Feminino";
    }
}
