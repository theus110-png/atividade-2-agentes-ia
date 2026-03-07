import java.util.ArrayList;
import java.util.List;

public class SistemaOrquestrador {

    public static void processarFila(List<AgenteIA> lista, String comando) {
        System.out.println("\n>>> Processando comando interno: \"" + comando + "\"");
        for (AgenteIA agente : lista) {
            try {
                agente.processarRequisicao(comando);
            } catch (ErroComunicacaoIAException | FalhaProcessamentoAgenteException | PromptInadequadoException e) {
                System.out.println("[ERRO INTERNO - " + agente.getNome() + "] " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- INICIANDO TESTES INTERNOS DOS AGENTES ---");
        List<AgenteIA> orquestrador = new ArrayList<>();
        orquestrador.add(new AgenteTexto("GPT-4"));
        orquestrador.add(new AgenteImagem("Midjourney"));
        processarFila(orquestrador, "Gere uma imagem de um cachorro");
        System.out.println("\n\n--- INICIANDO TESTE DE INTEROPERABILIDADE (PLUGINS) ---");

        AgenteIA meuAgente = new AgenteTexto("GitHub Copilot");
        IAcaoAgente pluginPesquisa = new PluginPesquisaWeb();
        IAcaoAgente pluginCodigo = new PluginGeradorCodigo();

        String comandoNormal = "Como aprender Java";
        meuAgente.usarHabilidade(pluginPesquisa, comandoNormal);
        meuAgente.usarHabilidade(pluginCodigo, comandoNormal);
        String comandoProibido = "Como hackear um banco de dados";
        meuAgente.usarHabilidade(pluginPesquisa, comandoProibido);
        
        String comandoLongo = "Crie um sistema completo em Java que faça conexão com banco de dados e gere relatorios em PDF";
        meuAgente.usarHabilidade(pluginCodigo, comandoLongo);
    }
}
