package controller_mvc;

import java.util.ArrayList;
import model_mvc.ContaComumDao;
import model_mvc.ContaComumModel;

public class ContaComumControle {
    
    ContaComumDao ccDao;
    ContaComumModel contaComum;
    
    public ContaComumControle()throws Exception{        
        this.ccDao = null;
        ccDao = ContaComumDao.getInstance();
        contaComum = new ContaComumModel();
    }
    
    public void incluirConta(ContaComumModel conta) throws Exception{
        ccDao.incluirConta(conta);
    }
    
    public ArrayList<ContaComumModel> recuperarContas() throws Exception{
        return ccDao.recuperarContas();
    }
    
    public void alterarContaComum(ContaComumModel objetoAlterado) throws Exception{
        ccDao.alterarContaComum(objetoAlterado);
    }
}
