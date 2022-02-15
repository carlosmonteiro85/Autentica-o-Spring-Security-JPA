# Executando o projeto

Para  executar o projeto, é necessário executar o arquivo "SecurityApplication.java", como "Java application" ou executando o comando mvn spring-boot:run 
no caminho src/main/java/br/com/examplesecurity/security/SecurityApplication.java.

# Banco em Memoria H2
Foi utilizado o banco de dados H2.
Após o projeto receber o build, é iniciado o H2, que é encontrado através do endpoint: http://localhost:8080/h2-console/ dados de acesso:

* JDBC URL: jdbc:h2:mem:security
* User: sa
* Password: vazio

## Utilizadouivo data.sql para injetar dados para os testes
### sprimeiro usuário carregado 
* user name: user
* password: pass
* perfil: "User 
### segundo usuário carregado
* user_name:admin
* password: pass
* perfil: "ADM


## Endpoint usados:

## Cotação
home:  
* Método get 
* End-point: http://localhost:8080/home

* End-point para administrador
  adm: Acassado apenas por usuários que tenhos a Role "ADM"
* Método get 
* End-point: http://localhost:8080/adm

* End-point para aberto
  hello: Acassado por usuários que tenhos a Role "ADM" ou "USER"
* Método get 
* End-point: http://localhost:8080/hello

* End-point de login
  login: Gerenciado pela framework Spring-Security com autenticação do usuario do bd.
* End-point: http://localhost:8080/login

principais configurações de segurança nos end-points
http.
			httpBasic()
        .and()
        	.authorizeRequests()
        	.antMatchers("/h2-console/**").permitAll() // caso use o H2 como data base.
        	.antMatchers("/hello").hasAnyAuthority("ADM", "USER") // Permite que o usuario ADM e o User tenham acesso.
        	.antMatchers("/adm").hasAnyAuthority("ADM")// Permite o usuário com role ADM o acesso.
        .and()
        	.formLogin(form -> form
        		.loginPage("/login")// URL da pagina de login
        		.defaultSuccessUrl("/home", true) //pagina usada para abrir ao se autenticar
        		.permitAll() // todos são permitidos acessar a pagina de login
            		).csrf().disable();
		http.headers().frameOptions().disable();

## Criptografia de senhas.
* Foi usada a api "BCryptPasswordEncoder" do Spring security para realizar a Criptografia das senhas.

