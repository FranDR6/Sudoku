package modelo;

public class Casilla {
	private int AREA;
	private int NUMERO;
	private boolean DESVELADA = false;
	
	

	public Casilla(int aREA) {
		super();
		AREA = aREA;
	}

	public int getAREA() {
		return AREA;
	}

	public void setAREA(int aREA) {
		AREA = aREA;
	}

	public int getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(int nUMERO) {
		NUMERO = nUMERO;
	}

	public boolean isDESVELADA() {
		return DESVELADA;
	}

	public void setDESVELADA(boolean dESVELADA) {
		DESVELADA = dESVELADA;
	}

}
