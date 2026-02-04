# Desafio de Votação - Projeto para Mentoria

## 🎯 Objetivo

Este projeto foi **intencionalmente criado com violações de SOLID e princípios RESTful** para ser usado em mentorias de desenvolvimento de software.

O mentorado deve identificar e corrigir todas as violações, transformando este código problemático em um código limpo e bem estruturado.

---

## 🎓 Exercícios para o Mentorado

### Nível 1: Identificação
1. Liste todas as violações SOLID encontradas
2. Liste todas as violações RESTful encontradas
3. Identifique code smells e más práticas

### Nível 2: Refatoração Básica
4. Criar DTOs para requisições e respostas
5. Corrigir os verbos HTTP e URLs dos endpoints
6. Implementar status codes HTTP apropriados
7. Separar validações em classes dedicadas
8. Remover lógica de negócio das entidades

### Nível 3: Refatoração Avançada
9. Aplicar SRP criando services especializados
10. Criar interfaces para aplicar DIP
11. Implementar strategy pattern para regras de negócio
12. Adicionar exception handling global
13. Implementar Bean Validation
14. Criar testes unitários

### Nível 4: Melhorias Arquiteturais
15. Adicionar documentação Swagger/OpenAPI
16. Implementar paginação
17. Adicionar HATEOAS
18. Criar versionamento da API
19. Implementar logging apropriado
20. Adicionar cache onde apropriado

---

## 💡 Dicas para o Mentorado

1. **Não tente corrigir tudo de uma vez!** Vá refatorando incrementalmente
2. **Escreva testes antes de refatorar** para garantir que o comportamento não muda
3. **Use ferramentas de análise estática** (SonarLint, Checkstyle)
4. **Documente suas decisões** de refatoração
5. **Compare antes e depois** para ver a melhoria
6. **Aprenda os princípios**, não apenas decore padrões

---

## 📚 Referências Recomendadas

- Clean Code (Robert C. Martin)
- Clean Architecture (Robert C. Martin)
- Refactoring (Martin Fowler)
- REST API Design Rulebook (Mark Masse)
- RESTful Web Services (Richardson & Ruby)

---

## ✅ Checklist de Refatoração

### SOLID
- [ ] Separar VotacaoService em múltiplos services
- [ ] Criar interfaces para os services (DIP)
- [ ] Remover lógica de negócio das entidades (SRP)
- [ ] Implementar strategy pattern para validações (OCP)
- [ ] Usar constructor injection (DIP)

### RESTful
- [ ] Corrigir todos os verbos HTTP
- [ ] Reestruturar URLs seguindo padrão REST
- [ ] Criar DTOs de request/response
- [ ] Implementar ResponseEntity com status codes corretos
- [ ] Remover lógica de negócio do controller

### Qualidade de Código
- [ ] Adicionar Bean Validation
- [ ] Criar exception handler global
- [ ] Implementar testes unitários
- [ ] ✅ Documentação Swagger já implementada (mas endpoints precisam refatoração)
- [ ] Implementar logging

---

## 🤝 Contribuindo

Este é um projeto educacional. Se você é um mentor e quer adicionar mais exemplos de violações, fique à vontade para contribuir!

---

**Lembre-se: Este código é propositalmente ruim! Não use em produção! 🚫**
