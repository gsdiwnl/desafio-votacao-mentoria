package br.com.db.desafio.votacao.exception;

public class InvalidVoteException extends RuntimeException {

    public InvalidVoteException(String message) {
        super(message);
    }
}
