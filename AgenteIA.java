public abstract class AgenteIA {
    protected String nome;
    protected String status;

    public AgenteIA(String nome) {
        this.nome = nome;
        this.status = "IDLE";
    }

    public String getNome() {
        return nome;
    }

    public void conectarServidor() throws ErroComunicacaoIAException {
        ModuloConexao.validarLink(); 
        this.status = "PROCESSING";
    }
    public abstract void processarRequisicao(String input) 
        throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException;
    public void usarHabilidade(IAcaoAgente ferramenta, String comando) {
        try {
            System.out.println("\n[" + this.nome + "] ativando ferramenta externa...");
            String resultado = ferramenta.executarAcao(comando);
            System.out.println("-> " + resultado);
        } catch (FalhaProcessamentoAgenteException | PromptInadequadoException | ErroComunicacaoIAException e) {
            System.out.println("[FALHA NA FERRAMENTA - " + this.nome + "] " + e.getMessage());
        }
    }
}
