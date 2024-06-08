# SampleGenerator

SampleGenerator es una utilidad para generar datos de muestra en Java, utilizando la librería `java-faker`. Esta librería puede ser útil para crear datos ficticios para pruebas y demostraciones.

## Instalación

Puedes incluir SampleGenerator en tu proyecto clonando este repositorio y agregando los archivos fuente a tu proyecto de Java.

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
```

## Uso

### Generación de Listas de Objetos

SampleGenerator te permite generar una lista de objetos poblados con datos ficticios.

```java
import io.terabyte.labs.utils.SampleGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<YourClass> samples = SampleGenerator.supplyInformation(YourClass.class, 10);
        samples.forEach(System.out::println);
    }
}
```

### Ejemplo de Clase

A continuación, se muestra un ejemplo de cómo debería verse tu clase para utilizarla con SampleGenerator.

```java
public class YourClass {
    private String name;
    private int age;
    private boolean active;

    // Getters y Setters

    @Override
    public String toString() {
        return "YourClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
```

### Tipos de Datos Soportados

SampleGenerator puede generar datos ficticios para los siguientes tipos de datos:
- `String`
- `int` / `Integer`
- `long` / `Long`
- `double` / `Double`
- `boolean` / `Boolean`
- `LocalDate`
- `List<String>`
- `List<Integer>`
- `List<Double>`
- `List<LocalDate>`

### Ejemplos de Uso de Faker

SampleGenerator utiliza `java-faker` para generar datos ficticios. Aquí hay algunos ejemplos de cómo se utilizan los métodos de Faker en SampleGenerator:

```java
private static String generateString(String fieldName) {
    if (fieldName.toLowerCase().contains("id")) {
        return faker.internet().uuid();
    } else if (fieldName.toLowerCase().contains("email")) {
        return faker.internet().emailAddress();
    } else if (fieldName.toLowerCase().contains("address")) {
        return faker.address().fullAddress();
    } else {
        return getRandomStringFromFaker();
    }
}
```

## Dependencias

- [java-faker](https://github.com/DiUS/java-faker)
- [SLF4J](http://www.slf4j.org/)

Asegúrate de agregar estas dependencias a tu proyecto. Si estás usando Maven, puedes incluirlas en tu `pom.xml`:

```xml
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.30</version>
</dependency>
```

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para mejorar el proyecto.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.
```
Este README.md proporciona una guía clara sobre cómo instalar, usar y contribuir a tu librería SampleGenerator. Asegúrate de ajustar los detalles específicos, como el nombre del repositorio y las clases de ejemplo, según tus necesidades.
```