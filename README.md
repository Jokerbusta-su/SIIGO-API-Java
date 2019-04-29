# SIIGO-API-Spring MVC
Este proyecto contiene el código fuente de un ejemplo de integración con la API de SIIGO. Cubre cómo autenticarse y consumir métodos para obtener registros, insertar y eliminar.

## Instrucciones

### 1. Requisitos
Para poder ejecutar el siguiente proyecto requiere en su aplicación web.

```
          - * jQuery -> https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js
          - Bootstrap -> https://getbootstrap.com/

*Este requisito es indispensable, dado que el lenguaje usado es javascript sobre jQuery
```

### 2. Métodos
A continuación los ejemplos de los métodos necesarios para interactuar con el API de SIIGO.

#### Obtener Token
Para interactuar con el API es necesario usar la seguridad por token, para eso se debe consumir el servicio https://siigonube.siigo.com:50050/connect/token que solicita el usuario y contraseña; retornando finalmente el token que se usara en el resto de solicitudes.

Ejemplo con Spring MVC
```
    public String getToken() {
		String token = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", TOKEN_BASIC);
			headers.set("Accept", "application/json");
			headers.set("Content-Type", "application/x-www-form-urlencoded");
			String body = BODY_TOKEN;
			HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
			ResponseEntity<String> response = restService.exchange(AdministrationConstants.REST_TOKEN,HttpMethod.POST,                        requestEntity, String.class);
			token = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return token;
	}
```
#### Consultas
Una vez se obtiene el token, se puede realizar consultas a los métodos definidos en el API <URL>, a continuación un ejemplo de la solicitud por ajax.

Ejemplo con Spring MVC (Obtener lista de desarrolladores)
```
    public Developer[] getDevelopers() {
		Developer[] listDeveloper = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<Developer[]> response = restService.exchange(AdministrationConstants.REST_GET_DEVELOPERS,
					HttpMethod.GET, requestEntity, Developer[].class);
			listDeveloper = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return listDeveloper;
	}
```

Ejemplo con Spring MVC (Obtener lista de productos)
```
    public Product[] getProducts() {
		Product[] listProducts = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<Product[]> response = restService.exchange(AdministrationConstants.REST_GET_PRODUCTS,
					HttpMethod.GET, requestEntity, Product[].class);
			listProducts = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return listProducts;
	}
```

#### Eliminar
Para realizar una eliminación es necesario enviar el id del objecto a eliminar, en este caso vamos a eliminar un producto.

Ejemplo con Spring MVC
```
    public boolean deleteProduct(Long product) {
		boolean status = false;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity response = restService.exchange(
					AdministrationConstants.REST_DELETE_PRODUCT + product + "?namespace=v1", HttpMethod.DELETE,
					requestEntity, Object.class);
			if (response.getStatusCode() == HttpStatus.OK)
				status = true;
			else
				status = false;
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return status;
	}
```

#### Crear
Para realizar una creación se requiere enviar los campos solicitados del objecto a crear.

Ejemplo con Spring MVC
```
    public Product createProduct(Product product) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			ObjectMapper mapper = new ObjectMapper();
			String strJSON = mapper.writeValueAsString(product);
			HttpEntity<String> requestEntity = new HttpEntity<>(strJSON, headers);
			ResponseEntity<Product> response = restService.exchange(AdministrationConstants.REST_CREATE_PRODUCT,
					HttpMethod.POST, requestEntity, Product.class);
			product = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return product;
	}
```
### 3. Estructura del Proyecto
En el proyecto se encuentra desarrollado con el framework MVC que incorpora Spring.

Se encuentran las siguientes carpetas y archivos
          - .mvn
          - .settings
          - src
          - target
          - pom.xml
  
#### src
```
Se encuentran los archivos fuentes que contienen los modelos, el controlador y archivos de configuración de la aplicación.
```
    
#### src/main/webapp
```
Se encuentra los formularios para las consultas.
```

#### src/main/resources
```
Se encuentra el archivo de configuración de la aplicación.
```

### 4. Configuración

- Clonar el proyecto
- Configurar <a href="https://medium.freecodecamp.org/how-to-get-https-working-on-your-local-development-environment-in-5-minutes-7af615770eec">HTTPS en su computador</a> *Esto para evitar el error por <a href="https://developer.mozilla.org/es/docs/Web/HTTP/Access_control_CORS">CORS</a>*
- Debe tener instalado Java v. 8 en su ambiente. <a href="https://www.java.com/es/download/">Instalar Java</a>
- Debe tener instalado Maven en su ambiente. <a href="https://maven.apache.org/install.html">Instalar Maven</a>
- Ingrese por linea de comandos a la capeta donde se encuentra el archivo pom.xml
- Ejecute el siguiente comando: *mvn clean install*
- Ingrese a la carpeta target y ejecute el siguiente comando: *java -jar web-siigo-0.0.1.war*
- Ingrese por un navegador ala siguiente URL: *http://localhost:8080* y comprueba el funcionamiento.
