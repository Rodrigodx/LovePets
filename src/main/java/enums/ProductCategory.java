package enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductCategory {
	VERMIFUGOS(1),
	MEDICAMENTOS(2),
	ANTIPULGAS(3),
	GATOS(4),
	CACHORRO(5),
	PASSAROS(6),
	PEIXES(7);
	
	public final Integer cod;
	
	private ProductCategory(Integer codigo) {
		this.cod = codigo;
	}
	
	
	public static Optional<ProductCategory> findByCode(Integer codigo){
		return Arrays.stream(values())
				.sequential()
				.filter(c -> c.cod.equals(codigo))
				.findFirst();
	}
	
}
