public class AgenteImagem extends AgenteIA {

    public AgenteImagem(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input) 
        throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
        
        conectarServidor();
        String inputMinusculo = input.toLowerCase();
        
        if (inputMinusculo.contains("hackear") || inputMinusculo.contains("roubar") || inputMinusculo.contains("biométrico")) {
            throw new PromptInadequadoException("Violação de Segurança: Termo sensível detectado no prompt visual.");
        }

        System.out.println("Agente de Imagem [" + getNome() + "] sintetizando pixels para: " + input);
        this.status = "IDLE";
    }
}