package model_mvc;

public class ClienteModel implements Comparable<ClienteModel> {

    private int id;
    private String nome;
    private String email;

    public ClienteModel() throws Exception {
    }

    public ClienteModel(String nome, String email) throws Exception {
        this.nome = nome;
        this.email = email;
    }

    public ClienteModel(String dadosTxtCliente) throws Exception {
        String[] strDados = dadosTxtCliente.split(";");
        if (strDados.length < 3) {
            throw new Exception("Dados incompletos do cliente#!\n");
        }
        id = Integer.parseInt(strDados[0]);
        nome = strDados[1];
        email = strDados[2];

    }
    
    public ClienteModel (int id) throws Exception{
        
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.id + ";" + this.nome + ";" + this.email + ";" ;
    }

    @Override
    public int compareTo(ClienteModel objeto) {
        return nome.compareToIgnoreCase(objeto.getNome());
    }

}
