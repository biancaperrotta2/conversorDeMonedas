# 💱 Conversor de Monedas - Java Console App

Este es un proyecto de consola en Java que permite realizar conversiones entre diferentes monedas utilizando la API pública de ExchangeRate.

## 🛠️ Tecnologías utilizadas

- Java 17
- GSON (para parsear JSON)
- HTTP Client (`java.net.http`)
- API de [ExchangeRate-API](https://www.exchangerate-api.com/)
- Entorno: IntelliJ IDEA / NetBeans / cualquier IDE compatible

---

## 🚀 ¿Qué hace esta aplicación?

- Permite al usuario elegir un tipo de conversión entre distintas monedas.
- Solicita al usuario el monto a convertir.
- Se conecta a la API para obtener la tasa de cambio actual.
- Muestra el resultado de la conversión.
- Repite el proceso hasta que el usuario decida salir.

---

## 🌐 Monedas disponibles en el menú

1. Dólar (USD) → Peso argentino (ARS)  
2. Peso argentino (ARS) → Dólar (USD)  
3. Dólar (USD) → Real brasileño (BRL)  
4. Real brasileño (BRL) → Dólar (USD)  
5. Dólar (USD) → Peso colombiano (COP)  
6. Peso colombiano (COP) → Dólar (USD)  
7. Salir  

---

## 🔧 Cómo ejecutar el proyecto

1. Clonar o descargar el repositorio.
2. Asegurarse de tener Java 17 o superior instalado.
3. Agregar GSON a tu proyecto:
   - Si usás Maven o Gradle: agregar dependencia.
   - Si es manual: descargar el `.jar` desde [aquí](https://repo1.maven.org/maven2/com/google/code/gson/gson/).
4. Ejecutar la clase `Main`.

---

## 🔐 API Key

Este proyecto utiliza una clave gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/). Si querés usar tu propia clave:

1. Crear una cuenta gratuita en el sitio.
2. Obtener tu propia API Key.
3. Reemplazar la key en:
```java
String url = "https://v6.exchangerate-api.com/v6/TU_API_KEY/pair/USD/ARS";

