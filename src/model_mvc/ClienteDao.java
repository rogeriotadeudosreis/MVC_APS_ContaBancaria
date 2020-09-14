package model_mvc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import classes_utilitarias.EnumArquivosTxt;

public class ClienteDao {
    
    public static ClienteDao instance;
    private final String nomeDoArquivo = EnumArquivosTxt.CLIENTES + ".txt";

    private ClienteDao() {
    }
    
    public static ClienteDao getInstance()throws Exception{
        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }
    
    public void incluirCliente(ClienteModel clienteModel) throws Exception {
        try {
            verificarArquivo();
            Util_GeradorIdentificador id = new Util_GeradorIdentificador();
            clienteModel.setId(id.getID());

            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(clienteModel.toString() + "\n");
            bw.close();
            id.finalize();

        } catch (Exception erro) {
            throw new Exception("Erro ao gravar esse registro de cliente\n");
        }
    }

    public ArrayList<ClienteModel> recuperar() throws Exception {
        try {
            verificarArquivo();
            ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ClienteModel cliente = new ClienteModel(linha);
                listaCliente.add(cliente);
            }
            br.close();
            return listaCliente;

        } catch (Exception erro) {
            throw new Exception("Erro ao recuperar os dados do cliente\n", erro);
        }

    }

    public void alterarCliente(ClienteModel objetoAlterado) throws Exception {
        try {
            verificarArquivo();
            ArrayList<ClienteModel> lista = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < lista.size(); pos++) {
                ClienteModel aux = lista.get(pos);
                if (objetoAlterado.getId() == aux.getId()) {
                    bw.write(objetoAlterado.toString() + "\n");
                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            throw new Exception("Erro ao alterar este registro de cliente\n" + erro);
        }

    }
    
    public void verificarArquivo() throws Exception {
        File arquivo = new File(nomeDoArquivo);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }
    
    public ClienteModel buscarPeloId(int id) throws Exception {
       verificarArquivo();
        try {

            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ClienteModel objetoCliente = new ClienteModel(linha);
                if (objetoCliente.getId() == id) {
                    br.close();
                    return objetoCliente;
                }
            }
            br.close();

            return null;
        } catch (Exception erro) {
            throw new Exception("Id do Autor não encontrado!" + erro.getMessage());
        }
    }
    
}
