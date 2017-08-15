package epam.java.flowers01.flower;

/**
 * Created by вова on 14.10.2016.
 */
public class FlowerSpec {

    protected FlowerColor color;
    protected double length;
    protected FlowerType type;

    public FlowerSpec(FlowerColor color, double length, FlowerType type) {
        this.color = color;
        this.length = length;
        this.type = type;
    }

    public FlowerType getType() {
        return type;
    }
    public double getLength() {
        return length;
    }
    public FlowerColor getColor() {
        return color;
    }

    public  boolean matches(FlowerSpec otherSpec){
        if (color != otherSpec.getColor())return false;
        if (length != otherSpec.getLength())return false;
        if (type != otherSpec.getType())return false;

        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FlowerSpec other = (FlowerSpec) obj;
		if (color != other.color)
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
    
    
}
