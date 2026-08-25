package Enum;

public enum State {
	
	    SELECT("Select"),
	    ANDHRA_PRADESH("ANDHRA PRADESH"),
	    KARNATAKA("KARNATAKA"),
	    KERALA("KERALA"),
	    TAMIL_NADU("TAMIL NADU"),
	    TELANGANA("TELANGANA"),
	    UTTAR_PRADESH("UTTAR PRADESH");

	    private final String name;

	    State(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
	}

