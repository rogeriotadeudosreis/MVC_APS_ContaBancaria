package model_mvc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import classes_utilitarias.EnumArquivosTxt;
import java.io.File;

public class ContaEspecialDao {
    
    public static ContaEspecialDao instance;
    
    private ContaEspecialDao(){
        
    }
    
    public static ContaEspecialDao getInstance() throws Exception{
        if (instance == null) {
            instance = new ContaEspecialDao();
        }
        return instance;
    }
    
    private String nomeDoArquivo = EnumArquivosTxt.CONTAS + ".txt";
    
    public void incluirContaEspecial(ContaEspecialModel conta) throws Exception {
        try {
            verificarArquivo();
            Util_GeradorIdentificador id = new Util_GeradorIdentificador();
            conta.setId(id.getID());

            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(conta.toString() + "\n");
            bw.close();
            id.finalize();

        } catch (Exception erro) {
            throw new Exception("Erro ao gravar esse registro da conta\n", erro);
        }
    }

    public ArrayList<ContaEspecialModel> recuperarContaEspecial() throws Exception {
        try {
            verificarArquivo();
            ArrayList<ContaEspecialModel> listaConta = new ArrayList<ContaEspecialModel>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ContaEspecialModel conta = new ContaEspecialModel(linha);
                listaConta.add(conta);
            }
            br.close();
            return listaConta;

        } catch (Exception erro) {
            throw new Exception("Erro ao recuperar os dados da conta\n", erro);
        }

    }

    public void alterarContaEspecial(ContaEspecialModel objetoAlterado) throws Exception {
        try {
            verificarArquivo();
            ArrayList<ContaEspecialModel> lista = recuperarContaEspecial();

            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < lista.size(); pos++) {
                ContaEspecialModel aux = lista.get(pos);
                if (objetoAlterado.getId() == aux.getId()) {
                    bw.write(objetoAlterado.toString() + "\n");
                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            throw new Exception("Erro ao alterar este registro da conta\n" + erro);
        }
    }

    public void verificarArquivo() throws Exception {
        File arquivo = new File(nomeDoArquivo);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }
    
    
    
    
}
