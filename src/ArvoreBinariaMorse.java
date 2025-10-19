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

    public String buscar(String codigoMorse) {
        int tamanho = codigoMorse.length();
        char caractere;
        String caractereMorse = "";
        String traducaoMorse = "";
        No atual = this.raiz;

        for (int i = 0; i < tamanho; i++) {
            caractere = codigoMorse.charAt(i);

            if (caractere != ' ') {
                caractereMorse = caractereMorse + caractere;
            }

            if (caractere == ' ' || i == tamanho - 1) {
                if (caractereMorse.length() > 0) {
                    atual = this.raiz;
                    boolean valido = true;

                    for (int j = 0; j < caractereMorse.length(); j++) {
                        char caractereAtualMorse = caractereMorse.charAt(j);

                        if (caractereAtualMorse == '.') {
                            if (atual.getFilhoEsquerdo() != null) {
                                atual = atual.getFilhoEsquerdo();
                            } else {
                                valido = false;
                                break;
                            }
                        } else if (caractereAtualMorse == '-') {
                            if (atual.getFilhoDireito() != null) {
                                atual = atual.getFilhoDireito();
                            } else {
                                valido = false;
                                break;
                            }
                        } else {
                            valido = false;
                            break;
                        }
                    }
                    if (valido) {
                        traducaoMorse = traducaoMorse + atual.getCaractereCorrespondente();
                    } else {
                        traducaoMorse = traducaoMorse + "(Caractere não identificado)";
                    }
                    caractereMorse = "";
                }

                if(i < tamanho - 1 && codigoMorse.charAt(i + 1) == ' ') {
                    traducaoMorse = traducaoMorse + " ";
                    i += 1;
                }
            }
        }
        return traducaoMorse;
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
