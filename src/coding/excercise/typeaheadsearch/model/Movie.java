/**
 * 
 */
package coding.excercise.typeaheadsearch.model;

/**
 * @author subbaramanv
 *
 */
public class Movie implements Comparable<Movie> {

	private String yearOfRelease;
	private String countryCode;
	private String name;
	
	/**
	 * @param yearOfRelease
	 * @param countryCode
	 * @param name
	 */
	public Movie(String yearOfRelease, String countryCode, String name) {
		super();
		this.yearOfRelease = yearOfRelease;
		this.countryCode = countryCode;
		this.name = name;
	}
	
	/**
	 * @return the yearOfRelease
	 */
	public String getYearOfRelease() {
		return yearOfRelease;
	}
	
	/**
	 * @param yearOfRelease the yearOfRelease to set
	 */
	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		int cmp = this.name.compareTo(o.getName());
		
		// if names are equal then check on second and third order comparisons
		// year of release and country.
		if(cmp == 0){
			cmp = this.yearOfRelease.compareTo(o.getYearOfRelease());
			if(cmp == 0){
				cmp = this.countryCode.compareTo(o.getCountryCode());
			}
		}
		
		return cmp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((yearOfRelease == null) ? 0 : yearOfRelease.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (yearOfRelease == null) {
			if (other.yearOfRelease != null)
				return false;
		} else if (!yearOfRelease.equals(other.yearOfRelease))
			return false;
		
		return true;
	}
	
	
	
}
