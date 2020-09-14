package controller_mvc;

import java.util.ArrayList;
import model_mvc.ClienteDao;
import model_mvc.ClienteModel;

public class ClienteControle {
    
    ClienteDao clienteDao;

    public ClienteControle() throws Exception{
        clienteDao = ClienteDao.getInstance();
    }
    
    public void incluirCliente(ClienteModel clienteModel) throws Exception {
        validaObjetoCliente(clienteModel);
        clienteDao.incluirCliente(clienteModel);
    }
    
    public ArrayList<ClienteModel> recuperar() throws Exception{
        return clienteDao.recuperar();
    }
    
   public void alterarCliente(ClienteModel objetoAlterado) throws Exception{
       validaObjetoCliente(objetoAlterado);
       clienteDao.alterarCliente(objetoAlterado);
   }
   
    public ArrayList pesquisar(String dados) throws Exception {
        ArrayList<ClienteModel> resultadoDaPesquisa = new ArrayList<>();
        boolean encontrado = false;
        for (ClienteModel cliente : clienteDao.recuperar()) {
            if (cliente.getNome().toLowerCase().trim().contains(dados)) {
                resultadoDaPesquisa.add(cliente);
                encontrado = true;
            } else if (cliente.getEmail().toLowerCase().trim().contains(dados)) {
                resultadoDaPesquisa.add(cliente);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new Exception("Registro não encontrado!\nPara criar uma conta cadastre o cliente!\n");
        }
        return resultadoDaPesquisa;
    }
    
    public void validaObjetoCliente(ClienteModel objetoCliente)throws Exception{
        
        String[] campos = {objetoCliente.getNome().trim().toLowerCase(),
            objetoCliente.getEmail().trim().toLowerCase()};
        for (int i = 0; i < campos.length; i++) {
            if (campos[i].equalsIgnoreCase("")) {
                throw new Exception("Existe(m) campos vazios!\nPor favor, preencha todos os campos.\n");
            }
        }
    }
    
    public ClienteModel buscarPeloId(int id) throws Exception {
        return clienteDao.buscarPeloId(id);
    }
}
