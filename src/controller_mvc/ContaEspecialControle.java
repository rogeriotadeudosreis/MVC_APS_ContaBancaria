package controller_mvc;

import java.util.ArrayList;
import model_mvc.ContaEspecialDao;
import model_mvc.ContaEspecialModel;

public class ContaEspecialControle {
    
    ContaEspecialDao ceDao;
    ContaEspecialModel contaEspecial;
    
    public ContaEspecialControle()throws Exception{
        this.ceDao = null;
        ceDao = ContaEspecialDao.getInstance();
        contaEspecial = new ContaEspecialModel();
    }
    
    public void incluirContaEspecial (ContaEspecialModel objeto)throws Exception{
        ceDao.incluirContaEspecial(objeto);
    }
    
    public ArrayList<ContaEspecialModel> recuperarContaEspecial()throws Exception{
        return ceDao.recuperarContaEspecial();
    }
    
    public void alterarContaEspecial(ContaEspecialModel objetoAlterado) throws Exception{
        ceDao.alterarContaEspecial(objetoAlterado);
    }

}
