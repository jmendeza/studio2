/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2015 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.api.v1.to;

import java.io.Serializable;

/**
 * 
 * holds the configuration for delete dependency
 * 
 * @author Shankar Krishnan
 *
 */
public class DeleteDependencyConfigTO implements Serializable {

    private static final long serialVersionUID = -8726953181196086267L;
    protected String pattern;
	
	protected boolean removeEmptyFolder;

	
	public DeleteDependencyConfigTO(String pattern, boolean removeEmptyFolder) {
		super();
		this.pattern = pattern;
		this.removeEmptyFolder = removeEmptyFolder;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public boolean isRemoveEmptyFolder() {
		return removeEmptyFolder;
	}

	public void setRemoveEmptyFolder(boolean removeEmptyFolder) {
		this.removeEmptyFolder = removeEmptyFolder;
	}


}
