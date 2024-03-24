# Teste Java Developer | TGID

Este repositório abriga a resolução do desafio Java Developer para a empresa TGID. O objetivo é criar uma aplicação que gerencie transações financeiras entre usuários.

&nbsp;

# Regras de Negócio

### Cadastro de Usuários:

Os usuários (Empresa ou Cliente) são cadastrados com os seguintes campos: nome, e-mail, senha, documento (CPF ou CNPJ), saldo inicial e userRole(EMPRESA ou CLIENTE).
O CPF/CNPJ são validados antes de serem inseridos, para que seja um atributo unico

### Realização de Saques e Depósitos:

Como o enunciado original não foi especifico, foi adotado a seguinte regra:

1. Em operação de Saque: Apenas o CLIENTE pode ser o destinatário, e a EMPRESA a remetente.
2. Em operação de Depósito: Apenas a EMPRESA pode ser o destinatário, e o CLIENTE o remetente.

O sistema calcula uma taxa fixa de 5% sobre o valor transferido.

### Notificações por E-mail:

Após cada transação, o sistema envia um e-mail para o remetente e o destinatário informando que a transação foi concluída com sucesso.

&nbsp;

# Tecnologias Utilizadas

- Spring Boot
- Banco de Dados H2
- Maven para gerenciamento de dependências

&nbsp;

# Instruções para Execução

1 | Clone este repositório.

```
https://github.com/uFelps/
```

2 | Abra o projeto no InteliJ ou STS e rode o projeto

3 | A API irá ficar disponivel em localhost:8080

&nbsp;

# Endpoints | Postman

Acesse o [Postman](https://www.postman.com/red-comet-846596/workspace/tgid/collection/23677590-8f24456e-09b4-4d76-958d-15bd3522dd6c?action=share&creator=23677590) para ver as rotas da API.
