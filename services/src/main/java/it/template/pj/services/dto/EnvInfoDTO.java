/**
 * 
 */
package it.template.pj.services.dto;

import java.io.Serializable;

/**
 * @author nicola.cremaschini
 *
 */
public class EnvInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5130097860774827363L;

	private String servicesTitle;
	
	private String servicesVersion;

	/**
	 * @return the servicesTitle
	 */
	public String getServicesTitle() {
		return servicesTitle;
	}

	/**
	 * @param servicesTitle the servicesTitle to set
	 */
	public void setServicesTitle(String servicesTitle) {
		this.servicesTitle = servicesTitle;
	}

	/**
	 * @return the servicesVersion
	 */
	public String getServicesVersion() {
		return servicesVersion;
	}

	/**
	 * @param servicesVersion the servicesVersion to set
	 */
	public void setServicesVersion(String servicesVersion) {
		this.servicesVersion = servicesVersion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("EnvInfoDTO [servicesTitle=%s, servicesVersion=%s]", servicesTitle, servicesVersion);
	}
		
}
