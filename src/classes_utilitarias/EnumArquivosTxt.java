package classes_utilitarias;

public enum EnumArquivosTxt {
    
    CLIENTES, IDGERADO, CONTAS, CONTACOMUM, CONTAESPECIAL;

    public static EnumArquivosTxt getCONTAS() {
        return CONTAS;
    }

    public static EnumArquivosTxt getCLIENTES() {
        return CLIENTES;
    }

    public static EnumArquivosTxt getIDGERADO() {
        return IDGERADO;
    }

    public static EnumArquivosTxt getCONTACOMUM() {
        return CONTACOMUM;
    }

    public static EnumArquivosTxt getCONTAESPECIAL() {
        return CONTAESPECIAL;
    }
    
    
}
