# Llanquihue Tour App - Semana 5

## Descripción
Aplicación de consola en Java para la agencia de turismo Llanquihue Tour. Lee los datos de
los clientes desde un archivo de texto, los carga en una colección (`ArrayList`), valida la
información, y permite mostrarlos y buscarlos por RUT o por ciudad.

## Paquetes y clases
- **model**: `Persona` (clase base), `Cliente` (hereda de Persona), `Rut` y `Direccion`.
  Persona usa composición: contiene un objeto `Rut` y un objeto `Direccion`.
- **data**: `GestorDatos` lee `clientes.txt`, crea los objetos, los guarda en un
  `ArrayList<Cliente>` y ofrece métodos para mostrar y buscar.
- **util**: `Validador` con validaciones reutilizables (texto vacío, número y correo).
- **ui**: `Main`, clase principal que ejecuta el programa.

## Archivo de datos
`src/main/resources/clientes.txt`, una línea por cliente con 11 campos separados por `;`:

`nombre;apellido;rut;teléfono;correo;calle;numero;ciudad;región;nacionalidad;idiomas`

Las líneas con errores (RUT inválido, datos faltantes o teléfono no numérico) se informan
por consola y se omiten, sin detener el programa.

## Cómo ejecutar
1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `cl.LlanquihueTour.ui.Main`.
3. Presionar el botón verde (Run) para ejecutar junto a `public static void main`.

## Autor
Jefferson Cid Aravena 

Desarrollo Orientado a Objetos I - DuocUC