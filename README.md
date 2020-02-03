# condominio-acme

# Projeto Pós-Graduação

# ENDPOINTS
 ----------------------Condominios------------------------------------------------------------------
 
* Criar Condominios (POST) --> localhost:8081/api/condominios/save                                   
* Listar Todos os Condominios (GET) --> localhost:8081/api/condominios                               
* Buscar Condominios por ID (GET) --> localhost:8081/api/condominios/{id do condominio}              

 ----------------------Unidades--------------------------------------------------------------------- 
 
* Adicionar Unidades (POST) --> localhost:8081/api/unidades/salvarUnidade/{id do Condominio}         
* Listar Todos as Unidades (GET) --> localhost:8081/api/unidades                                     
* Buscar Unidades por ID (GET) --> localhost:8081/api/unidades/{id da unidade}                       

 ------------------------Multas---------------------------- -----------------------------------------
 
* Multar Unidades(POST) --> localhost:8081/api/multas/emitirMultas/{id do condominio}/{id da unidade}
* Listar Todas as Multas (GET) --> localhost:8081/api/multas                                         
* Buscar Multas por ID (GET) --> localhost:8081/api/multas/{id da multa}                             

 ------------------------Avisos----------------------------------------------------------------------
 
* Emitir Aviso(POST) --> localhost:8081/api/avisos/emitirAviso/{id do condominio}/{id da unidade}    
* Listar Todos os avisos (GET) --> localhost:8081/api/avisos                                         
* Buscar Avisos por ID (GET) --> localhost:8081/api/avisos/{id do aviso}                             
