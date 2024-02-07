public class Rational {
	// Data fields for numerator and denominator
	private BigInteger[] r = new BigInteger[2];

	/** Construct ratinoal with default properties */
	public Rational() {
		this(new BigInteger("0"), new BigInteger("1"));
	}

	/** Construct rational with specifiec numerator and denominator */
	public Rational(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = gcd(numerator, denominator);
		r[0] = (denominator.compareTo(BigInteger.ZERO) > 0
			? BigInteger.ONE : 
			new BigInteger("-1")).multiply(numerator.divide(gcd));
		r[1] = denominator.divide(gcd);
	}

	/** Find gcd */
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n;
		BigInteger n2 = d;
		BigInteger gcd = BigInteger.ONE;

		for (BigInteger k = BigInteger.ONE; 
			k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; 
			k = k.add(BigInteger.ONE)) {
			if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0 && 
				n2.remainder(k).compareTo(BigInteger.ZERO) == 0)
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public BigInteger getNumerator() {
		return r[0];
	}

	/** Return denominator */
	public BigInteger getDenominator() {
		return r[1];
	}

	/** Add rational number */
	public Rational add(Rational secondRational) {
		BigInteger n = (r[0].multiply(secondRational.getDenominator())).add(
			r[1].multiply(secondRational.getNumerator()));
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	/** Subtract rational number */
	public Rational subtract(Rational secondRational) {
		BigInteger n = (r[0].multiply(secondRational.getDenominator())).subtract(
			r[1].multiply(secondRational.getNumerator()));
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	/** Mulitply rational number */
	public Rational multiply(Rational secondRational) {
		BigInteger n = r[0].multiply(secondRational.getNumerator());
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	/** Divide a rational number */
	public Rational divide(Rational secondRational) {
		BigInteger n = r[0].multiply(secondRational.getDenominator());
		BigInteger d = r[1].multiply(secondRational.getNumerator());
		return new Rational(n, d);
	}

	@Override
	public String toString() {
		if (r[1].compareTo(BigInteger.ONE) == 0)
			return r[0] + "";
		else
			return r[0] + "/" + r[1];
	}

	@Override // Override equals method in Object class
	public boolean equals(Object other) {
		if (((this.subtract((Rational)(other))).getNumerator()).compareTo(
			BigInteger.ZERO) == 0)
			return true;
		else
			return false;
	}

	@Override // Implement abstract intValue method
	public int intValue() {
		return (int)doubleValue();
	}

	@Override // Implement abstract floatValue method
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override // Implement doubleValue method
	public double doubleValue() {
		return this.getNumerator().doubleValue() / 
			this.getDenominator().doubleValue();
	}

	@Override // Implement abstract longValue method
	public long longValue() {
		return (long)doubleValue();
	}

	@Override
	public int compareTo(Object o) {
		BigInteger zero = BigInteger.ZERO;
		BigInteger n = this.subtract((Rational)o).getNumerator();
		if (n.compareTo(zero) > 0)
			return 1;
		else if (n.compareTo(zero) < 0)
			return -1;
		else
			return 0;
	}
}
