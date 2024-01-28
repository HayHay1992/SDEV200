public class BinaryFormatException {

/** construct BinaryFormatException */
	public BinaryFormatException(String binaryString) {
		super(binaryString + " is not a binary string");
		this.binaryString = binaryString;
	}

	public String getBinaryString() {
		return binaryString;
	}
}
