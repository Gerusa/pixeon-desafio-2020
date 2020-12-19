# Repositório pixeon-desafio-2020
 Armazena o projeto desenvolvido referente ao desafio tecnológico, do processo seletivo da Pixeon, em 12/2020. Link do desafio: https://github.com/Pixeon/tech-challenge.
 
# Sobre o Projeto
* API REST para controle dos registros das instituições de saúde, bem como dos exames dessas instituições.
* Projeto desenvolvido em java 8 com spring boot, criado a partir de https://start.spring.io/.
* O arquivo *Pixeon.postman_collection* é um export collection do postman, que contém as chamadas a todos os serviços implementados no projeto.
* Servidor configurado na porta **8090**.

# H2 Database
O projeto utiliza o banco h2: dependência adicionada no pom e propriedades configuradas em application.properties, onde foi definida a utilização do console do h2 pelo caminho h2.console -> *localhost:8090/h2-console*.
