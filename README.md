# API REST com Autenticação JWT

Seguindo de acordo com a regra de negócio estabelecidade pelo professor, trabalho está ainda incompleto, porém será feito um update para correção de entidades, modelos das entidades nos DTO's e validação de campos para melhor aproveitamento e melhorias.

### Entendimento da aplicação e modelo do fluxo construído.

*Controller*: Recebe requisições, interpreta e aciona serviços para gerar respostas. Define caminhos de acesso (rotas) e encapsula lógica para lidar com requisições (ações).

*DTO*: Encapsula dados relevantes para cada operação, otimizando o fluxo, simplificando a comunicação dos dados.

*Entidade*: Representa o modelo de negócio, mapeando dados para tabelas e colunas. Utiliza de ferramentas como JPA e Hibernate para estruturar e definir relacionamentos.

*Repositório*: Abstrai a interação com o banco de dados, fornece métodos estáticos para consultar, inserir, atualizar e excluir dados.

*Mapper*: Converte dados entre diferentes formatos (entidades em DTOs e vice-versa). Permitindo regras de negócio especifica entre os dados.

*Service*: Encapsula a lógica de negócio da aplicação e o processamento dos dados, definindo os métodos na qual a aplicação irá atuar.

*Impl*: Concretiza os métodos abstratos definidos no service, fornecendo a implementação específica e/ou personalizada desses métodos. Utiliza do DI para injetar as dependências necessárias.

### Fluxo de Execução:

Requisição do Owner chega ao Controller.
Controller valida, extrai dados e converte para DTO.
Controller chama o Service com o DTO.
Service utiliza o DTO para acessar dados no Repositório.
Service processa dados, aplica regras e toma decisões.
Service converte dados processados em um novo DTO.
Service retorna o DTO para o Controller.
Controller converte o DTO para o formato de resposta (JSON, HTML, etc.).
Controller envia a resposta para o Owner.
