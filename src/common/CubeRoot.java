package common;
public class CubeRoot {

	public CubeRoot() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CubeRoot c = new CubeRoot();
		double r = c.compute(0.001);
		System.out.println(r);
	}

	public double compute(double d) {
		double s = 0;
		double l = 0;
		if (d >= 1.0) {
			s = 1;
			l = d;
		} else {
			s = d;
			l = 1;
		}

		while (s <= l) {
			double m = (s + l) / 2;
			double t = m * m * m;
			System.out.println(m + " " + t);
			if (Math.abs(t- d) < 0.000000000001) {
				System.out.println("=");
				return m;
			} else if (t < d) {
				System.out.println("<");
				s = m;
			} else {
				System.out.println(">");
				l = m;
			}
		}

		return -1;
	}

}
