package se.lexicon.FlightReservationMvc.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Food {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int ID;
	
private String type;

private int price;

protected Food() {
	
}

public Food(String type, int price) {

this.type = type;
this.price = price;

}

public int getID() {
	return ID;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ID;
	result = prime * result + price;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Food other = (Food) obj;
	if (ID != other.ID)
		return false;
	if (price != other.price)
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}

@Override
public String toString() {
	return "Food [ID=" + ID + ", type=" + type + ", price=" + price + "]";
}





}
