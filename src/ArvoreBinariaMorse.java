public class ArvoreBinariaMorse {
    private final No raiz;

    public ArvoreBinariaMorse(){
        this.raiz = new No(' ');
    }

    public void inserir(String codigoMorse, char caractereCorrespondente){
        if (buscar(codigoMorse) != '\0') return;
        No atual = this.raiz;
        char caractere;
        boolean fim;
        int tamanho = codigoMorse.length();
        for(int i = 0; i < tamanho; i++){
            caractere = codigoMorse.charAt(i);
            fim = i == tamanho - 1;

            if(caractere == ' ') continue;

            switch (caractere){
                case '.':
                    if (atual.getFilhoEsquerdo() == null){
                        No novo_no = new No(caractere);

                        if (fim){
                            novo_no.setFinalDaPalavra(fim);
                            novo_no.setCaractereCorrespondente(caractereCorrespondente);
                        }

                        atual.setFilhoEsquerdo(novo_no);
                    }
                    else if (fim){
                        No proximo = atual.getFilhoEsquerdo();
                        proximo.setFinalDaPalavra(fim);
                        proximo.setCaractereCorrespondente(caractereCorrespondente);
                    }

                    atual = atual.getFilhoEsquerdo();
                    break;
                case '-':
                    if (atual.getFilhoDireito() == null){
                        No novo_no = new No(caractere);

                        if (fim){
                            novo_no.setFinalDaPalavra(fim);
                            novo_no.setCaractereCorrespondente(caractereCorrespondente);
                        }

                        atual.setFilhoDireito(novo_no);
                    }
                    else if (fim){
                        No proximo = atual.getFilhoDireito();
                        proximo.setFinalDaPalavra(fim);
                        proximo.setCaractereCorrespondente(caractereCorrespondente);
                    }
                    atual = atual.getFilhoDireito();
                    break;
            }
        }
    }

    public char buscar(String caractereMorse) {
        int tamanho = caractereMorse.length();
        char caractere;
        No atual = this.raiz;

        for(int i = 0; i < tamanho; i++) {
            caractere = caractereMorse.charAt(i);

            if(caractere == ' ') continue;

            if(caractere == '.') {
                if(atual.getFilhoEsquerdo() == null) {
                    return '\0';
                }
                atual = atual.getFilhoEsquerdo();
            } else if(caractere == '-') {
                if(atual.getFilhoDireito() == null) {
                    return '\0';
                }
                atual = atual.getFilhoDireito();
            } else {
                return '\0';
            }
        }
        if(atual.eFinalDaPalavra()) {
            return atual.getCaractereCorrespondente();
        } else {
            return '\0';
        }
    }

    public boolean remover(String codigoMorse) {
        if (codigoMorse == null || codigoMorse.length() == 0) return false;

        No atual = raiz;
        No pai = null;
        boolean filhoEsquerdo = false;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char c = codigoMorse.charAt(i);
            pai = atual;

            if (c == '.') {
                atual = atual.getFilhoEsquerdo();
                filhoEsquerdo = true;
            } else if (c == '-') {
                atual = atual.getFilhoDireito();
                filhoEsquerdo = false;
            } else {
                return false;
            }

            if (atual == null) return false;
        }

        if (atual.getFilhoEsquerdo() != null || atual.getFilhoDireito() != null) {
            atual.setCaractereCorrespondente('\0');
            atual.setFinalDaPalavra(false);
        } else {
            if (filhoEsquerdo) {
                pai.setFilhoEsquerdo(null);
            } else {
                pai.setFilhoDireito(null);
            }
        }
        return true;
    }


    public void imprimir() {
        No[] fila = new No[150];
        String[] caminhos = new String[150];
        int comeco = 0;
        int fim = 0;

        fila[fim] = raiz;
        caminhos[fim] = "";
        fim++;

        while (comeco < fim) {
            No atual = fila[comeco];
            String caminho = caminhos[comeco];
            comeco++;

            if (atual == null) continue;

            if (atual.eFinalDaPalavra()) {
                System.out.println("(" + caminho + ") → " + atual.getCaractereCorrespondente());
            } else {
                System.out.println("(" + caminho + ")");
            }

            if (atual.getFilhoEsquerdo() != null) {
                fila[fim] = atual.getFilhoEsquerdo();
                caminhos[fim] = caminho + ".";
                fim++;
            }
            if (atual.getFilhoDireito() != null) {
                fila[fim] = atual.getFilhoDireito();
                caminhos[fim] = caminho + "-";
                fim++;
            }
        }
    }




}
