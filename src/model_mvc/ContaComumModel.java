package model_mvc;

import classes_utilitarias.Enum_TipoDeConta;

public class ContaComumModel extends ContaModel {

    public ContaComumModel() {
    }

    public ContaComumModel(int id,String conta, int idCliente, Enum tipoDeConta, double limite) throws Exception {
        super(id, conta, idCliente, tipoDeConta, limite);
    }

    @Override
    public boolean saque(double valor) throws Exception {
        return ((valor > super.getSaldo()) ? false : super.saque(valor));
    }

    public ContaComumModel(String dadosTxtConta) throws Exception {
        String[] strDados = dadosTxtConta.split(";");
        if (strDados.length < 6) {
            throw new Exception("Dados incompletos da conta comum da conta ? !\n");
        }
        id = Integer.parseInt(strDados[0]);
        conta = strDados[1];
        idCliente = Integer.parseInt(strDados[2]);   
        if (strDados[3].equalsIgnoreCase("Comum")) {
            tipoDeConta = Enum_TipoDeConta.COMUM;
        } else if (strDados[3].equalsIgnoreCase("Especial")) {
            tipoDeConta = Enum_TipoDeConta.ESPECIAL;
        }
        saldo = Double.parseDouble(strDados[4]);
        limite = Double.parseDouble(strDados[5]);
    }

}
