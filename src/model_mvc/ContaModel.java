package model_mvc;

import classes_utilitarias.Enum_TipoDeConta;

public abstract class ContaModel {

    protected int id;
    protected String conta;
    protected int idCliente;
    protected Enum tipoDeConta;
    protected double saldo;
    protected double limite;
    
    public ContaModel(){
        
    }

    public ContaModel(int id,String conta, int idCliente, Enum tipoDeConta, double limite) throws Exception {
        this.id = id;
        this.conta = conta;
        this.idCliente = idCliente;
        this.tipoDeConta = tipoDeConta;
        this.saldo = 0;
        this.limite = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getidCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }

    public Enum getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(Enum tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
        if (tipoDeConta.equals(Enum_TipoDeConta.COMUM)) {
            this.limite = 0;
        }
    }

    public double getSaldo() {
        return saldo + limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void deposito(double valor) throws Exception {
        saldo += valor;
    }

    public boolean saque(double valor) throws Exception {
        return true;
    }

    @Override
    public String toString() {
        String saida = this.id + ";";
        saida += this.conta + ";";
        saida += this.idCliente + ";";
        saida += this.tipoDeConta + ";";
        saida += this.saldo + ";";
        saida += this.limite + ";";
        return saida;
    }
}
