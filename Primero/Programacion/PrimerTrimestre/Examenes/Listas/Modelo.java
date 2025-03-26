package Primero.Programacion.PrimerTrimestre.Examenes.Listas;

import java.util.*;

//HashMap<PRODUCTO, HashMap<ATRIBUTO, VALOR>>
public class Modelo extends HashMap<Producto, HashMap<String, String>> {

	// Devuelve el valor de un atributo espec�fico para un producto dado.
	//Si no existe el producto o no existe el atributo devuelve null.
	public String obtenerAtributo(Producto producto, String atributo) {
		// Condicional compacto, en caso de que no halla un registro de producto, se devuelve null.
		// Si hay registro, entonces se obtiene el atributo, que este es null por defecto en caso de no existir.
		return this.get(producto) != null ? this.get(producto).get(atributo) : null;
	}

	// Devuelve un conjunto de productos que tienen un atributo pasado
	//por par�metro.
	public Set<Producto> obtenerProductosConAtributo(String atributo) {
		Set<Producto> foundProducts = new HashSet<>();

		// Hago un loop completo del map, usando el entrySet para asi obtener las keys y los values
		// Asi puedo fácilmente comprobar si un producto tiene un atributo, por lo que lo añado a una lista la cual es devuelta.
		for (Map.Entry<Producto, HashMap<String, String>> mapEntry : this.entrySet()) {
			Producto producto = mapEntry.getKey();
			HashMap<String, String> atributosMap = mapEntry.getValue();

			if (atributosMap.containsKey(atributo)) {
				foundProducts.add(producto);
			}
		}

		return foundProducts;
	}

	// Devuelve un String. Este m�todo buscar� y devolver� el nombre del producto
	// con el precio m�s alto en el modelo.
	public String obtenerProductoPrecioMasAlto() {
		Producto productoMasCaro = null;
		double precioMasAlto = 0;

		for (Producto producto : this.keySet()) {
			if (producto.getPrecio() > precioMasAlto) {
				precioMasAlto = producto.getPrecio();
				productoMasCaro = producto;
			}
		}

		return (productoMasCaro != null) ? productoMasCaro.getNombre() : "No se ha podido encontrar ningun producto en el modelo!";
	}

	// Devuelve un HashMap<String, Integer>, donde las claves son las
	// categor�as de los productos y los valores es la cantidad de productos
	// pertenecientes a cada categor�a.
	public HashMap<String, Integer> numeroProductosporCategorias() {
		HashMap<String, Integer> productsByCategory = new HashMap<>();

		// Si no existe, se añade, si existe se incremente en 1 del actual.
		for (Producto producto : this.keySet()) {
			if (!productsByCategory.containsKey(producto.getCategoria())) {
				productsByCategory.put(producto.getCategoria(), 1);
			} else {
				productsByCategory.put(producto.getCategoria(), productsByCategory.get(producto.getCategoria()) + 1);
			}
		}

		return productsByCategory;
	}
}