package trabalhofinalPOO2;

public class ResumoProxy {
    private Resumo resumo;
    private String senha = "1234"; 
    public ResumoProxy(int carros, float arrecadacao) {
        resumo = new Resumo(carros, arrecadacao);
    }

    public String getSenhaCorreta() {
        return senha;
    }

    public void att(double taxa) {
    	resumo.atualizar(taxa);
    }
    
    public String toString(String senha) {
        if (senha != null && this.senha.equals(senha)) {
            return resumo.toString();
        } else {
            return "Acesso negado. Senha incorreta.\n";
        }
    }
}

