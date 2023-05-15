package dam.thymleft.warhammer40k.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "popularidad")
public class Popularidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int puntuacion;
	
	@ManyToOne
	private Producto producto;

	
	public Popularidad() {
	}
	
	public Popularidad(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	

	public Popularidad(int puntuacion, Producto producto) {
		this.puntuacion = puntuacion;
		this.producto = producto;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
