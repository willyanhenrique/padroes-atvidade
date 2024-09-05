public abstract class Tarefa {
    protected final String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return (concluida ? "[Concluída] " : "[Pendente] ") + obterDescricao();
    }


    protected abstract String obterDescricao();
}

