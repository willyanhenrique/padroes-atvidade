public class TarefaNormal extends Tarefa {
    public TarefaNormal(String descricao) {
        super(descricao);
    }

    @Override
    protected String obterDescricao() {
        return "Tarefa Normal: " + super.descricao;
    }
}

