public class AgenteTexto extends AgenteIA {

    public AgenteTexto(String nome) {
        super(nome);
    }
    @Override
    public void processarRequisicao(String input) 
        throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
        conectarServidor(); 
        if (input.length() > 500) {
            throw new FalhaProcessamentoAgenteException("Estouro de Contexto: O prompt tem mais de 500 caracteres.");
        }

        System.out.println("Agente de Texto [" + getNome() + "] gerando resposta para: " + input);
        this.status = "IDLE";
    }
}