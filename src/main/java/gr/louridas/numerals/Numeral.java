package gr.louridas.numerals;

public class Numeral {
    private int value;

    public Numeral() {
	this.value = 0;
    }
    
    public Numeral(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    protected void setValue(int value) {
	this.value = value;
    }

    public Numeral add(Numeral other) {
	int resultValue = this.getValue() + other.getValue();
	Numeral result = new Numeral(resultValue);
	return result;
    }

    public Numeral subtract(Numeral other) {
	int resultValue = this.getValue() - other.getValue();
	Numeral result = new Numeral(resultValue);
	return result;
    }

    public Numeral multiply(Numeral other) {
	int resultValue = this.getValue() * other.getValue();
	Numeral result = new Numeral(resultValue);
	return result;
    }

    public Numeral divide(Numeral other) {
	int resultValue = this.getValue() / other.getValue();
	Numeral result = new Numeral(resultValue);
	return result;
    }
}
