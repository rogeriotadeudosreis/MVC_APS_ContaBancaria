package model_mvc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import classes_utilitarias.EnumArquivosTxt;
import java.io.File;

public class ContaComumDao {
    
    public static ContaComumDao instance;
    
    private ContaComumDao(){
        
    }
    
    public static ContaComumDao getInstance()throws Exception{
        if (instance == null) {
            instance = new ContaComumDao();
        }
        return instance;
    }

    private String nomeDoArquivo = EnumArquivosTxt.CONTAS + ".txt";

    public void incluirConta(ContaComumModel conta) throws Exception {
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

    public ArrayList<ContaComumModel> recuperarContas() throws Exception {
        try {
            verificarArquivo();
            ArrayList<ContaComumModel> listaConta = new ArrayList<ContaComumModel>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ContaComumModel conta = new ContaComumModel(linha);
                listaConta.add(conta);
            }
            br.close();
            return listaConta;

        } catch (Exception erro) {
            throw new Exception("Erro ao recuperar os dados da conta\n", erro);
        }

    }

    public void alterarContaComum(ContaComumModel objetoAlterado) throws Exception {
        try {
            verificarArquivo();
            ArrayList<ContaComumModel> lista = recuperarContas();

            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < lista.size(); pos++) {
                ContaComumModel aux = lista.get(pos);
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
