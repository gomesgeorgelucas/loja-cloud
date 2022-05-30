package org.letscode.servicoproduto.domain.exception;

public class ProdutoNotFoundException extends EntityNotFoundException{

    private static final long serialVersionUID = 1L;

    public ProdutoNotFoundException(String mensagem){
        super(mensagem);
    }

}
