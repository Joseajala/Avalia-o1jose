package controlePiloto.Impl.Excecoes;

public class PilotoNaoEncontradoException extends Exception {
    public PilotoNaoEncontradoException(String cpf) {
        super("Não foi possível encontrar o Piloto com o CPF: " + cpf);
    }   
}
