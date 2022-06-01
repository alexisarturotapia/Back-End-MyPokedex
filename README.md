# Back-End-MyPokedex
* Back end hecho en Spring Boot
* Se integra con una api externa(https://pokeapi.co/).
* Expone un Api Rest.
* La respuesta de la api externa son almacenadas en cache.
* Contiene tests unitarios (Junit + Mokito)
* Contiene log (Log4j).
* Contiene un manejo de errores personalizado.
* Se ha procurado un trabajo en Java y Json limpio y ordenado.

# Llamadas:  
Para listar todos los pokemons de 20 en 20  
(La información que expone es: Link con la imagen del pokemon, nombre, id, tipo, las habilidades, peso).  
http://localhost:8080/mypokedex/pokemons/?offset=0

Para listar la evolución de un pokemon  
http://localhost:8080/mypokedex/evolution/{id}

Para listar la descripción de un pokemon  
http://localhost:8080/mypokedex/description/{id}

Para limpiar la cache  
http://localhost:8080/mypokedex/flushcache

# Siguientes pasos:  
* Corregir algún bug que descubra. 
* Desarrollo Front End e intregar.
* Desplegar Back End y Front End.

