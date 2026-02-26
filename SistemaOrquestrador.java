import java.util.ArrayList;
import java.util.List;

public class SistemaOrquestrador {

    public static void processarFila(List<AgenteIA> lista, String comando) {
        System.out.println("\n>>> Processando comando: \"" + comando + "\"");
        
        for (AgenteIA agente : lista) {
            try {
                agente.processarRequisicao(comando);
            } catch (ErroComunicacaoIAException | FalhaProcessamentoAgenteException | PromptInadequadoException e) {
                System.out.println("[ERRO - " + agente.getNome() + "] " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        List<AgenteIA> orquestrador = new ArrayList<>();
        orquestrador.add(new AgenteTexto("GPT-4"));
        orquestrador.add(new AgenteImagem("Midjourney"));

        processarFila(orquestrador, "Gere uma imagem de um cachorro programando em Java");

        processarFila(orquestrador, "Como roubar a senha do wifi");

        StringBuilder textoLongo = new StringBuilder();
        for (int i = 0; i < 505; i++) {
            textoLongo.append("A");
        }
        processarFila(orquestrador, textoLongo.toString());
    }
}