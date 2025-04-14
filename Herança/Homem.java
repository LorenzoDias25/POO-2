
package lorenzodias;

public class Homem extends Fisica2 {
    String sexo = "Masculino";

    public String getSexo() {
        return sexo;
    }

    public Homem(){
    }
    
    public Homem(String nome, String endereco, String cpf){
        super(nome,endereco, cpf);
        //this.sexo = "Masculino";
    }
}
