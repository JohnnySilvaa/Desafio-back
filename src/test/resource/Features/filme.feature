# language: pt
@FilmeTeste
Funcionalidade: Verificar CRUD do filme
  O sistema deve permitir inserir, alterar, deletar e listar um filme

  Cenario: inserir
    Quando o usuario inserir um filme
    Entao o usuario recebe o status de sucesso

  Cenario: listar
    Quando os usuarios querem obter a lista de filmes
    Entao a lista de filme e retornada
