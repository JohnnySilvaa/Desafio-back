#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
# language: pt

@SessaoTeste
Funcionalidade: Testar o preco da sessao
  O sistema deve prover o armazenamento do preco de forma correta.


 Contexto: Cria sala e filme e associa a sessao
    Dado que as sala tem nome "Rogue One" e preco "22.5"
    Dado que o filme possui nome "Rogue One" e duracao de 120 e genero "SCI-FI" e preco "12"

  Cenario: Verifica o preco da sessao
    Dado o horario da sessao "10:00:00" e filme e sala
    Entao o preco da sessao deve ser igual a soma da sala e filme
