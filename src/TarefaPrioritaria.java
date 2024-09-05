public class TarefaPrioritaria extends Tarefa {
    public TarefaPrioritaria(String descricao) {
        super(descricao);
    }

    @Override
    protected String obterDescricao() {
        return "Tarefa Prioritária: " + super.descricao;
    }
}
