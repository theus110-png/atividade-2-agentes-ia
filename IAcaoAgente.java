public interface IAcaoAgente {
    String executarAcao(String comando) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException;
}