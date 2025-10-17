public class No {
    private char caractereMorse;
    private No filhoEsquerdo;
    private No filhoDireito;
    private boolean finalDaPalavra;
    private char caractereCorrespondente;

    public No(char caractereMorse){
        this.caractereMorse = caractereMorse;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.finalDaPalavra = false;
        this.caractereCorrespondente = ' ';
    }

    public char getCaractereMorse() {
        return caractereMorse;
    }

    public void setCaractereMorse(char caractereMorse) {
        this.caractereMorse = caractereMorse;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public boolean eFinalDaPalavra() {
        return finalDaPalavra;
    }

    public void setFinalDaPalavra(boolean finalDaPalavra) {
        this.finalDaPalavra = finalDaPalavra;
    }

    public char getCaractereCorrespondente() {
        return caractereCorrespondente;
    }

    public void setCaractereCorrespondente(char caractereCorrespondente) {
        this.caractereCorrespondente = caractereCorrespondente;
    }
}
