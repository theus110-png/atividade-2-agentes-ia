public class PluginPesquisaWeb implements IAcaoAgente {

    @Override
    public String executarAcao(String comando) throws PromptInadequadoException {
        String comandoMinusculo = comando.toLowerCase();
        
        if (comandoMinusculo.contains("hackear") || comandoMinusculo.contains("roubar")) {
            throw new PromptInadequadoException("Termo proibido detectado na tentativa de Pesquisa Web.");
        }
        
        return "Resultado da pesquisa no Google sobre: [" + comando + "]";
    }
}