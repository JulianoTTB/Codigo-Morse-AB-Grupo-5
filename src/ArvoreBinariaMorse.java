public class ArvoreBinariaMorse {
    private final No raiz;

    public ArvoreBinariaMorse(){
        this.raiz = new No(' ');
    }

    public void inserir(String codigoMorse, char caractereCorrespondente){
        if (buscar(codigoMorse) != null) return;
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
                    atual = atual.getFilhoDireito();
                    break;
            }
        }
    }
}
