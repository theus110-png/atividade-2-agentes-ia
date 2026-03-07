public class PluginGeradorCodigo implements IAcaoAgente {

    @Override
    public String executarAcao(String comando) throws FalhaProcessamentoAgenteException {
        if (comando.length() > 50) {
            throw new FalhaProcessamentoAgenteException("Limite de tokens de código excedido (mais de 50 caracteres).");
        }
        
        return "Snippet de código Java gerado para: [" + comando + "]";
    }
}